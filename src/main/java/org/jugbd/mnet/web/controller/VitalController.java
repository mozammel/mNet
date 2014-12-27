package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.domain.Vital;
import org.jugbd.mnet.service.RegisterService;
import org.jugbd.mnet.service.VitalService;
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
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/17/14.
 */
@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
@RequestMapping(value = "vital")
public class VitalController {
    private static final Logger log = LoggerFactory.getLogger(VitalController.class);

    @Autowired
    private VitalService vitalService;

    @Autowired
    private RegisterService registerService;

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

    @RequestMapping(value = "back", method = RequestMethod.GET)
    public String backToPatientShowPage(@RequestParam Long registerId) {
        log.debug("back() registerId={}", registerId);
        Register register = registerService.findOne(registerId);

        return "redirect:/patient/show/" + register.getPatient().getId();
    }
}
