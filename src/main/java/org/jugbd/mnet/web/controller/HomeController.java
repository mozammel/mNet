package org.jugbd.mnet.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {



    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String firstPage(ModelMap model) {
        log.debug("at first page");

        model.addAttribute("msg", "Welcomes MediNet Services!");
        return "index";
    }

}
