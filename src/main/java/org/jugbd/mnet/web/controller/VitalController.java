package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.domain.Vital;
import org.jugbd.mnet.service.VitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/17/14.
 */
@Controller
@RequestMapping(value = "vital")
public class VitalController {

    @Autowired
    private VitalService vitalService;

    @RequestMapping(value = "/create/{registerId}", method = RequestMethod.GET)
    public String create(@PathVariable Long registerId, Vital vital, Model uiModel) {

        uiModel.addAttribute("registerId", registerId);

        return "vital/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String save(@Valid Vital vital, BindingResult result, Long registerId, Model uiModel) {

        if (registerId == null) {
            throw new RuntimeException("Unable to find Register Id");
        }

        if (result.hasErrors()) {
            uiModel.addAttribute("registerId", registerId);

            return "vital/create";
        }

       Vital savedVital = vitalService.saveByRegisterId(vital, registerId);

        return "redirect:/vital/show/" + savedVital.getId();
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Long id, Model uiModel) {

        Vital vital = vitalService.findOne(id);
        uiModel.addAttribute("vital", vital);

        return "vital/show";
    }
}
