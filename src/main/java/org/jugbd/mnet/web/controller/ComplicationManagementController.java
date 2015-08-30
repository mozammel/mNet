package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.dao.RegisterDao;
import org.jugbd.mnet.domain.ComplicationManagement;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.service.ComplicationManagementService;
import org.jugbd.mnet.service.RegisterService;
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
 * @author Bazlur Rahman Rokon
 * @date 12/26/14.
 */
@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
@RequestMapping("complicationmanagement")
public class ComplicationManagementController {
    @Autowired
    private ComplicationManagementService complicationManagementService;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private RegisterDao registerDao;

    @RequestMapping(value = "create/{registerId}", method = RequestMethod.GET)
    public String create(@PathVariable Long registerId, ComplicationManagement complicationManagement) {
        Register register = registerService.findOne(registerId);
        complicationManagement.setRegister(register);

        return "complicationmanagement/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String save(@Valid ComplicationManagement complicationManagement,
                       BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            return "complicationmanagement/create";
        }

        ComplicationManagement complicationManagementSaved = complicationManagementService.save(complicationManagement);

        redirectAttributes.addFlashAttribute("message", "Complication Management successfully created");
        return "redirect:/patient/show/" + complicationManagementSaved.getRegister().getPatient().getId();
    }


    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Long id, Model uiModel) {
        ComplicationManagement complicationManagement = complicationManagementService.findOne(id);

        uiModel.addAttribute("complicationManagement", complicationManagement);

        return "complicationmanagement/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String update(@Valid ComplicationManagement complicationManagement,
                         BindingResult result,
                         RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {

            return "complicationmanagement/edit";
        }

        ComplicationManagement saveMedicalHistory = complicationManagementService.save(complicationManagement);

        redirectAttributes.addFlashAttribute("message", "Complication Management successfully updated");
        return "redirect:/patient/show/" + saveMedicalHistory.getRegister().getPatient().getId();
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable Long id) {
        ComplicationManagement one = complicationManagementService.findOne(id);
        Long patientId = one.getRegister().getPatient().getId();

        complicationManagementService.delete(one);

        return "redirect:/patient/show/" + patientId;
    }

    @RequestMapping(value = "cancel/{registerId}", method = RequestMethod.GET)
    public String cancel(@PathVariable Long registerId) {

        return "redirect:/patient/show/" + registerService.findOne(registerId).getPatient().getId();
    }

}
