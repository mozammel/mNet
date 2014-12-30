package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.domain.Investigation;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.domain.enums.Gender;
import org.jugbd.mnet.domain.enums.Relationship;
import org.jugbd.mnet.service.InvestigationService;
import org.jugbd.mnet.service.RegisterService;
import org.jugbd.mnet.web.editor.GenderEditor;
import org.jugbd.mnet.web.editor.RelationshipEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.annotation.Secured;
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
 * @date 12/27/14.
 */
@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
@RequestMapping("investigation")
public class InvestigationController {

    @Autowired
    private InvestigationService investigationService;

    @Autowired
    private RegisterService registerService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
    }


    @RequestMapping(value = "create/{registerId}", method = RequestMethod.GET)
    public String create(@PathVariable Long registerId, Investigation investigation) {
        Register register = registerService.findOne(registerId);
        investigation.setRegister(register);

        return "investigation/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String save(@Valid Investigation investigation, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            return "investigation/create";
        }

        Investigation investigationSaved = investigationService.save(investigation);

        redirectAttributes.addFlashAttribute("message", "Investigation successfully created");
        return "redirect:/investigation/show/" + investigationSaved.getId();
    }


    @RequestMapping(value = "show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Long id, Model uiModel) {
        Investigation investigation = investigationService.findOne(id);

        uiModel.addAttribute("investigation", investigation);

        return "investigation/show";
    }


    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Long id, Model uiModel) {
        Investigation investigation = investigationService.findOne(id);

        uiModel.addAttribute("investigation", investigation);

        return "investigation/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String update(@Valid Investigation investigation,
                         BindingResult result,
                         RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {

            return "investigation/edit";
        }

        Investigation saveInvestigationSaved = investigationService.save(investigation);

        redirectAttributes.addFlashAttribute("message", "Investigation successfully updated");
        return "redirect:/investigation/show/" + saveInvestigationSaved.getId();
    }

    @RequestMapping(value = "cancel/{registerId}", method = RequestMethod.GET)
    public String cancel(@PathVariable Long registerId) {

        return "redirect:/patient/show/" + registerService.findOne(registerId).getPatient().getId();
    }
}
