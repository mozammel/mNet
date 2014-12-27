package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.service.PatientService;
import org.jugbd.mnet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bazlur on 7/3/14.
 */
@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
public class AdminController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"admin/index", "/"}, method = RequestMethod.GET)
    public String index(Model uiModel) {

        uiModel.addAttribute("totalPatient", patientService.count());
        uiModel.addAttribute("totalUser", userService.count());

        return "admin/index";
    }
}
