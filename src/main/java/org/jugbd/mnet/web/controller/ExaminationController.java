package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.domain.Examination;
import org.jugbd.mnet.domain.OutdoorRegister;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.domain.enums.RegistrationType;
import org.jugbd.mnet.service.ExaminationService;
import org.jugbd.mnet.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @author Bazlur Rahman Rokon
 * @date 11/29/2014.
 */
@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
@RequestMapping("examination")
public class ExaminationController {

    @Autowired
    private ExaminationService examinationService;

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "create/{registerId}", method = RequestMethod.GET)
    public String create(@PathVariable Long registerId,
                         @RequestParam(required = true) RegistrationType registrationType,
                         Examination examination,
                         Model uiModel) {

        uiModel.addAttribute("registrationType", registrationType);

        if (registrationType == RegistrationType.OUTDOOR) {
            OutdoorRegister outdoorRegister = registerService.findOpdRegister(registerId);
            examination.setOutdoorRegister(outdoorRegister);

        } else if (registrationType == RegistrationType.INDOOR) {
            Register register = registerService.findOne(registerId);
            examination.setRegister(register);
        }

        return "examination/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String save(@RequestParam RegistrationType registrationType,
                       @Valid Examination examination,
                       BindingResult result,
                       RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            return "examination/create";
        }

        Examination examinationFromDb = examinationService.save(examination, registrationType);
        redirectAttributes.addFlashAttribute("message", "Diagnosis successfully created!");

        if (registrationType == RegistrationType.OUTDOOR) {

            return "redirect:/register/examination/" + examinationFromDb.getOutdoorRegister().getId() + "?registrationType=" + registrationType;
        }

        return "redirect:/patient/show/" + examination.getRegister().getPatient().getId();
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Long id,
                       @RequestParam RegistrationType registrationType,
                       Model uiModel) {

        Examination examination = examinationService.findOne(id);
        uiModel.addAttribute("examination", examination);
        uiModel.addAttribute("registrationType", registrationType);

        return "examination/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String update(@RequestParam RegistrationType registrationType,
                         @Valid Examination examination,
                         BindingResult result,
                         RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            return "examination/edit";
        }

        Examination examinationFromDb = examinationService.save(examination, registrationType);
        redirectAttributes.addFlashAttribute("message", "Examination successfully updated");

        if (registrationType == RegistrationType.OUTDOOR) {

            return "redirect:/register/examination/" + examinationFromDb.getOutdoorRegister().getId() + "?registrationType=" + registrationType;
        }

        return "redirect:/patient/show/" + examinationFromDb.getRegister().getPatient().getId();
    }

    @RequestMapping(value = "cancel/{registerId}", method = RequestMethod.GET)
    public String cancel(@PathVariable Long registerId) {

        return "redirect:/patient/show/" + registerService.findOne(registerId).getPatient().getId();
    }
}
