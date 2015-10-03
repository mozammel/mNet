package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.domain.*;
import org.jugbd.mnet.domain.enums.RegistrationType;
import org.jugbd.mnet.service.PatientService;
import org.jugbd.mnet.service.RegisterService;
import org.jugbd.mnet.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/14/14.
 */
@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
@RequestMapping("register")
public class RegisterController {
    private static final Logger log = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private PatientService patientService;

    @Autowired
    private RegisterService registerService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
    }

    @RequestMapping(value = "patient/{patientId}", method = RequestMethod.GET)
    public String create(@PathVariable(value = "patientId") Long patientId, Model uiModel) {
        log.debug("create() -> patientId ={}", patientId);

        Patient patient = patientService.findOne(patientId);
        Register register = new Register();
        register.setPatient(patient);
        uiModel.addAttribute("register", register);

        return "register/create";
    }


    @RequestMapping(value = "opd/{patientId}/new", method = RequestMethod.GET)
    public String createOutPatient(@PathVariable(value = "patientId") Long patientId, Model uiModel) {
        log.debug("create() -> patientId ={}", patientId);

        Patient patient = patientService.findOne(patientId);

        OutdoorRegister outdoorRegister = new OutdoorRegister();
        outdoorRegister.setPatient(patient);
        uiModel.addAttribute("outdoorRegister", outdoorRegister);

        return "register/opd";
    }

    @RequestMapping(value = "opd/save", method = RequestMethod.POST)
    public String saveOpd(@Valid OutdoorRegister outdoorRegister,
                          BindingResult result,
                          RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            return "register/opd";
        }

        registerService.save(outdoorRegister);

        return "redirect:/register/opd/" + outdoorRegister.getId();
    }

    @RequestMapping(value = "opd/{id}", method = RequestMethod.GET)
    public String openOpdRegistration(@PathVariable Long id, Model uiModel) {
        OutdoorRegister outdoorRegister = registerService.findOpdRegister(id);
        uiModel.addAttribute("register", outdoorRegister);

        return "register/opd-registration";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@Valid Register register,
                       BindingResult result,
                       RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            return "register/create";
        }


        registerService.save(register);

        return "redirect:/patient/show/" + register.getPatient().getId();
    }

    @RequestMapping(value = "close/{registerId}", method = RequestMethod.POST)
    public String close(@PathVariable(value = "registerId") Long registerId) {
        log.debug("close() -> registerId ={}", registerId);

        registerService.closeRegister(registerId);

        return "redirect:/patient/show/" + registerService.findOne(registerId).getPatient().getId();
    }

    @RequestMapping(value = "cancel/{patientId}", method = RequestMethod.GET)
    public String cancel(@PathVariable(value = "patientId") Long patientId) {
        log.debug("cancel()");

        return "redirect:/patient/show/" + patientId;
    }

    @RequestMapping(value = "/edit/{registrationId}", method = RequestMethod.GET)
    public String editRegistration(@PathVariable Long registrationId,
                                   @RequestParam(value = "type") String type,
                                   Model uiModel) {

        if (StringUtils.isNotEmpty(type) && type.equalsIgnoreCase("opd")) {
            OutdoorRegister outdoorRegister = registerService.findOpdRegister(registrationId);
            uiModel.addAttribute("outdoorRegister", outdoorRegister);

            return "register/opd-edit";
        } else {
            Register register = registerService.findOne(registrationId);

            uiModel.addAttribute("register", register);

            return "register/edit";
        }
    }

    @RequestMapping(value = "opd/update", method = RequestMethod.POST)
    public String updateOpd(@Valid OutdoorRegister outdoorRegister,
                            BindingResult result,
                            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            return "register/opd-edit";
        }

        registerService.save(outdoorRegister);

        return "redirect:/register/opd/" + outdoorRegister.getId();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateRegistration(@Valid Register register) {
        Register savedRegister = registerService.save(register);

        return "redirect:/patient/show/" + savedRegister.getPatient().getId();
    }

    //Diagnosis

    @RequestMapping(value = "/diagnosis/{registerId}", method = RequestMethod.GET)
    public String diagnosis(@PathVariable Long registerId,
                            @RequestParam RegistrationType registrationType,
                            Model uiModel) {

        Diagnosis diagnosis = registerService.findDiagnosis(registerId, registrationType);
        uiModel.addAttribute("diagnosis", diagnosis);
        uiModel.addAttribute("register", registerService.findRegister(registerId, registrationType));
        uiModel.addAttribute("registrationType", registrationType);

        return "register/diagnosis";
    }

    //Plan of Rx

    @RequestMapping(value = "/treatmentplan/{registerId}", method = RequestMethod.GET)
    public String treatmentPlan(@PathVariable Long registerId,
                            @RequestParam RegistrationType registrationType,
                            Model uiModel) {

        uiModel.addAttribute("treatmentPlan", registerService.findTreatmentPlan(registerId, registrationType));
        uiModel.addAttribute("register", registerService.findRegister(registerId, registrationType));
        uiModel.addAttribute("registrationType", registrationType);

        return "register/treatmentplan";
    }

}

