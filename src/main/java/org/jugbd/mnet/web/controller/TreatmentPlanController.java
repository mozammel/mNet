package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.domain.OutdoorRegister;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.domain.TreatmentPlan;
import org.jugbd.mnet.domain.enums.RegistrationType;
import org.jugbd.mnet.service.RegisterService;
import org.jugbd.mnet.service.TreatmentPlanService;
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
 * @date 12/25/14.
 */
@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
@RequestMapping(value = "treatmentplan")
public class TreatmentPlanController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private TreatmentPlanService treatmentPlanService;

    @RequestMapping(value = "create/{registerId}", method = RequestMethod.GET)
    public String create(@PathVariable Long registerId,
                         @RequestParam(required = true) RegistrationType registrationType,
                         TreatmentPlan treatmentPlan,
                         Model uiModel) {

        uiModel.addAttribute("registrationType", registrationType);
        registerService.findRegisterEither(registerId, registrationType)
                .map(treatmentPlan::setRegister, treatmentPlan::setOutdoorRegister);

        return "treatmentplan/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String save(@RequestParam(required = true) RegistrationType registrationType,
                       @Valid TreatmentPlan treatmentPlan,
                       BindingResult result,
                       RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            return "treatmentplan/create";
        }

        TreatmentPlan treatmentPlanSaved = treatmentPlanService.save(treatmentPlan, registrationType);
        redirectAttributes.addFlashAttribute("message", "Diagnosis successfully created!");

        if (registrationType == RegistrationType.OUTDOOR) {

            return "redirect:/register/treatmentplan/" + treatmentPlanSaved.getOutdoorRegister().getId() + "?registrationType=" + registrationType;
        }

        return "redirect:/patient/show/" + treatmentPlanSaved.getRegister().getPatient().getId();
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Long id,
                       @RequestParam RegistrationType registrationType,
                       Model uiModel) {

        TreatmentPlan treatmentPlan = treatmentPlanService.findOne(id);
        uiModel.addAttribute("treatmentPlan", treatmentPlan);
        uiModel.addAttribute("registrationType", registrationType);

        return "treatmentplan/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String update(@RequestParam RegistrationType registrationType,
                         @Valid TreatmentPlan treatmentPlan,
                         BindingResult result,
                         RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            return "treatmentplan/edit";
        }

        TreatmentPlan treatmentPlanSaved = treatmentPlanService.save(treatmentPlan, registrationType);
        redirectAttributes.addFlashAttribute("message", "Diagnosis successfully created!");

        if (registrationType == RegistrationType.OUTDOOR) {

            return "redirect:/register/treatmentplan/" + treatmentPlanSaved.getOutdoorRegister().getId() + "?registrationType=" + registrationType;
        }

        return "redirect:/patient/show/" + treatmentPlanSaved.getRegister().getPatient().getId();
    }

    @RequestMapping(value = "cancel/{registerId}", method = RequestMethod.GET)
    public String cancel(@PathVariable Long registerId) {

        return "redirect:/patient/show/" + registerService.findOne(registerId).getPatient().getId();
    }
}
