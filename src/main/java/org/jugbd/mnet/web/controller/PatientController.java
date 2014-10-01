package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.domain.Patient;
import org.jugbd.mnet.domain.enums.Gender;
import org.jugbd.mnet.domain.enums.Relationship;
import org.jugbd.mnet.service.PatientService;
import org.jugbd.mnet.service.UserService;
import org.jugbd.mnet.web.editor.GenderEditor;
import org.jugbd.mnet.web.editor.RelationshipEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ronygomes
 */
@Controller
@RequestMapping("/patient")
public class PatientController {
    private static final Logger log = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private PatientService patientService;

    @Autowired
    private UserService userService;

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

        if (patient.getAgeEstimated() != null) {
            patient.setBirthdateFromAge(patient.getAgeEstimated(), null);
        }

        validatePatient(patient, result);

        if (result.hasErrors()) {
            log.debug("save() result.getAllErrors() ={}", result.getAllErrors());

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

        return "patient/create";
    }

    @RequestMapping(value = {"/", "/index", "/list"}, method = RequestMethod.GET)
    public String index(@RequestParam(value = "page", required = false) Integer page,
                        @RequestParam(value = "size", required = false) Integer size,
                        Model uiModel) {
        log.debug("index() page={}, size={}", page, size);

        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size;
            final int firstResult = page == null ? 0 : (page - 1) * sizeNo;
            uiModel.addAttribute("patients", patientService.findAll(firstResult, sizeNo));
            float nrOfPages = (float) patientService.count() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("patients", patientService.findAll());
        }

        return "patient/index";
    }

    @RequestMapping(value = "show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model uiModel) {
        log.debug("show()");

        uiModel.addAttribute("patient", patientService.findOne(id));

        return "patient/show";
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

    @RequestMapping(value = "/display", method = RequestMethod.POST)
    public String display(@ModelAttribute("patientSearchCmd") PatientSearchCmd patientSearchCmd, Model uiModel) {
        log.debug("display()");

        if ((patientSearchCmd.getHealthId().isEmpty() && patientSearchCmd.getPhoneNumber().isEmpty())) {

            uiModel.addAttribute("patientSearchCmd", patientSearchCmd);
            uiModel.addAttribute("error", "Please enter Health Id or Phone Number");

            return "patient/search";
        }

        List<Patient> patientList = patientService.findByHealthIdOrPhoneNumber(patientSearchCmd.getHealthId(), patientSearchCmd.getPhoneNumber());
        if (patientList == null || patientList.size() == 0) {

            uiModel.addAttribute("patientSearchCmd", patientSearchCmd);
            uiModel.addAttribute("notFound", "The patient Information you are looking for, doesn't exist!");

            return "patient/search";
        }

        uiModel.addAttribute("patients", patientList);

        return "patient/index";
    }
}
