package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.domain.Patient;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.domain.Vital;
import org.jugbd.mnet.domain.enums.Gender;
import org.jugbd.mnet.domain.enums.Relationship;
import org.jugbd.mnet.service.PatientService;
import org.jugbd.mnet.service.RegisterService;
import org.jugbd.mnet.utils.PageWrapper;
import org.jugbd.mnet.utils.StringUtils;
import org.jugbd.mnet.web.editor.GenderEditor;
import org.jugbd.mnet.web.editor.RelationshipEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author ronygomes
 */
@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
@RequestMapping("/patient")
public class PatientController {
    private static final Logger log = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private PatientService patientService;

    @Autowired
    private RegisterService registerService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(Gender.class, new GenderEditor());
        binder.registerCustomEditor(Relationship.class, new RelationshipEditor());
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Patient patient, Model uiModel) {

        return "patient/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String save(@Valid Patient patient,
                       BindingResult result,
                       RedirectAttributes redirectAttributes) {

        if (patient.getAge() == null && patient.getBirthdateEstimated()) {
            patient.setBirthdateFromAge(patient.getAgeEstimated(), null);
        }

        validatePatient(patient, result);

        if (result.hasErrors()) {

            return "patient/create";
        }

        patientService.create(patient);

        redirectAttributes.addFlashAttribute("message", String.format("Patient successfully created"));

        return "redirect:/patient/show/" + patient.getId().toString();
    }

    private void validatePatient(Patient patient, BindingResult result) {
        if (patient.getAge() == null) {
            result.rejectValue("ageEstimated", "error.patient.age", "Enter date of birth or an approximate age");
        }
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Long id, Model uiModel) {

        Patient selectedPatient = patientService.findOne(id);
        uiModel.addAttribute("patient", selectedPatient);

        return "patient/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String update(Patient patient,
                         BindingResult result,
                         RedirectAttributes redirectAttributes) {

        validatePatient(patient, result);

        if (result.hasErrors()) {

            return "patient/edit";
        }

        patientService.update(patient);

        redirectAttributes.addFlashAttribute("message", String.format("Patient successfully updated"));

        return "redirect:/patient/show/" + patient.getId().toString();
    }

    @RequestMapping(value = {"/", "/index", "/list"}, method = RequestMethod.GET)
    public String index(Model uiModel, Pageable pageable) {

        Page<Patient> patients = patientService.findAll(pageable);
        PageWrapper<Patient> page = new PageWrapper<>(patients, "/patient/list");
        uiModel.addAttribute("page", page);

        return "patient/index";
    }

    @RequestMapping(value = "show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id,
                       @RequestParam(value = "registerId", required = false) Long registerId,
                       Model uiModel) {

        Patient patient = patientService.findOne(id);
        uiModel.addAttribute("patient", patient);
        uiModel.addAttribute("registers", registerService.findAllRegisterByPatientId(patient.getId()));

        Register activeRegister;

        if (registerId != null) {
            activeRegister = registerService.findOne(registerId);
        } else {
            activeRegister = registerService.findActiveRegisterByPatientId(id);
        }

        if (activeRegister != null) {
            uiModel.addAttribute("register", activeRegister);
            uiModel.addAttribute("lastVital", getLastVital(activeRegister));
        }

        return "patient/show";
    }

    @RequestMapping(value = "details/{id}", method = RequestMethod.GET)
    public String details(@PathVariable("id") Long id, Model uiModel) {

        uiModel.addAttribute("patient", patientService.findOne(id));

        return "patient/details";
    }

    @RequestMapping(value = "cancel", method = RequestMethod.GET)
    public String cancel() {
        log.debug("cancel()");

        return "redirect:/patient/list";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(Model uiModel) {
        log.debug("search()");

        uiModel.addAttribute("patientSearchCmd", new PatientSearchCmd());

        return "patient/search";
    }

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public String display(@ModelAttribute("patientSearchCmd") PatientSearchCmd patientSearchCmd, Pageable pageable, Model uiModel, HttpServletRequest request) {
        log.info("display() patientSearchCmd ={}", patientSearchCmd);

        if (StringUtils.isEmpty(patientSearchCmd.getHealthId())
                && StringUtils.isEmpty(patientSearchCmd.getPhoneNumber())
                && StringUtils.isEmpty(patientSearchCmd.getName())
                && StringUtils.isEmpty(patientSearchCmd.getRegisterId())) {

            uiModel.addAttribute("patientSearchCmd", patientSearchCmd);
            uiModel.addAttribute("error", "Please enter Health Id or Phone Number or Register Id");

            return "patient/search";
        }

        Page patients = patientService.findPatientBySearchCmd(patientSearchCmd, pageable);
        if (patients.getTotalElements() == 0) {

            uiModel.addAttribute("patientSearchCmd", patientSearchCmd);
            uiModel.addAttribute("notFound", "The patient Information you are looking for, doesn't exist!");

            return "patient/search";
        }

        PageWrapper<Patient> page = new PageWrapper<>(patients, "/patient/display?" + request.getQueryString());
        uiModel.addAttribute("page", page);

        return "patient/index";
    }

    private Vital getLastVital(Register activeRegister) {
        List<Vital> vitals = new ArrayList<>(activeRegister.getVitals());

        if (vitals.size() > 0) {
            Collections.sort(vitals, new Comparator<Vital>() {
                @Override
                public int compare(Vital o1, Vital o2) {
                    return o2.getCreatedDate().compareTo(o1.getCreatedDate());
                }
            });

            return vitals.get(0);
        }

        return null;
    }
}
