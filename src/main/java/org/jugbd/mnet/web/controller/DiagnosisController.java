package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.domain.Diagnosis;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.service.DiagnosisService;
import org.jugbd.mnet.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @author Mushfekur Rahman (mushfek0001)
 */
@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
@RequestMapping("/diagnosis")
public class DiagnosisController {

    private static final Logger log = LoggerFactory.getLogger(DiagnosisController.class);

    @Autowired
    private DiagnosisService diagnosisService;

    @Autowired
    private RegisterService registerService;


    @RequestMapping(value = "/create/{registerId}", method = RequestMethod.GET)
    public String create(@PathVariable Long registerId, Diagnosis diagnosis) {

        Register register = registerService.findOne(registerId);
        diagnosis.setRegister(register);

        return "diagnosis/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String save(@Valid Diagnosis diagnosis,
                       BindingResult result,
                       RedirectAttributes redirectAttrs) {

        if (result.hasErrors()) {

            return "diagnosis/create";
        }

        Diagnosis diagnosisFromDb = diagnosisService.save(diagnosis);
        redirectAttrs.addFlashAttribute("message", "Diagnosis successfully created!");

        return "redirect:/patient/show/" + diagnosisFromDb.getRegister().getPatient().getId();
    }

    @RequestMapping(value = "/edit/{diagnosisId}", method = RequestMethod.GET)
    public String edit(@PathVariable("diagnosisId") Long diagnosisId, Model uiModel) {

        Diagnosis diagnosis = diagnosisService.findOne(diagnosisId);
        uiModel.addAttribute("diagnosis", diagnosis);

        return "diagnosis/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String update(@Valid Diagnosis diagnosis,
                         BindingResult result,
                         RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            return "diagnosis/create";
        }

        Diagnosis diagnosisFromDb = diagnosisService.save(diagnosis);
        redirectAttributes.addFlashAttribute("message", "Diagnosis successfully updated!");

        return "redirect:/patient/show/" + diagnosisFromDb.getRegister().getPatient().getId();
    }
}
