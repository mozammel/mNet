package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.domain.LifeStyle;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.service.LifeStyleService;
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
@Secured("ROLE_ADMIN, ROLE_USER")
@RequestMapping("lifestyle")
public class LifeStyleController {

    @Autowired
    private LifeStyleService lifeStyleService;

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "create/{registerId}", method = RequestMethod.GET)
    public String create(@PathVariable Long registerId, LifeStyle lifeStyle) {
        Register register = registerService.findOne(registerId);
        lifeStyle.setRegister(register);

        return "lifestyle/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String save(@Valid LifeStyle lifeStyle,
                       BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            return "lifestyle/create";
        }

        LifeStyle lifeStyleSaved = lifeStyleService.save(lifeStyle);

        redirectAttributes.addFlashAttribute("message", "Life Style successfully created");
        return "redirect:/patient/show/" + lifeStyleSaved.getRegister().getPatient().getId();
    }


    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Long id, Model uiModel) {
        LifeStyle lifeStyle = lifeStyleService.findOne(id);

        uiModel.addAttribute("lifeStyle", lifeStyle);

        return "lifestyle/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String update(@Valid LifeStyle lifeStyle,
                         BindingResult result,
                         RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {

            return "lifestyle/edit";
        }

        LifeStyle savedLifeStyle = lifeStyleService.save(lifeStyle);

        redirectAttributes.addFlashAttribute("message", "Life Style successfully updated");
        return "redirect:/patient/show/" + savedLifeStyle.getRegister().getPatient().getId();
    }

    @RequestMapping(value = "cancel/{registerId}", method = RequestMethod.GET)
    public String cancel(@PathVariable Long registerId) {

        return "redirect:/patient/show/" + registerService.findOne(registerId).getPatient().getId();
    }
}
