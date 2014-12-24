package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.domain.Patient;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.service.PatientService;
import org.jugbd.mnet.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/14/14.
 */
@Controller
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
}

