package org.jugbd.mnet.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by bazlur on 7/3/14.
 */
@Controller
public class PatientIntakeController {
    private static final Logger log = LoggerFactory.getLogger(PatientIntakeController.class);

    @RequestMapping(value = "/intake", method = RequestMethod.GET)
    public String intake(Principal principal) {
        log.debug("intake() principal = {}", principal.getName());

        return "intake";
    }
}
