package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.domain.Diagnosis;
import org.jugbd.mnet.domain.User;
import org.jugbd.mnet.service.DiagnosisService;
import org.jugbd.mnet.service.UserService;
import org.jugbd.mnet.utils.DateUtils;
import org.jugbd.mnet.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.text.ParseException;
import java.util.Date;

/**
 * @author Mushfekur Rahman (mushfek0001)
 * on 7/15/14.
 */
@Controller
@RequestMapping("/diagnosis")
public class DiagnosisController {

    private static final Logger log = LoggerFactory.getLogger(DiagnosisController.class);

    @Autowired
    private DiagnosisService diagnosisService;

    @Autowired
    private UserService userService;

    @ModelAttribute("diagnosis")
    private Diagnosis getDiagnosis() {
        return new Diagnosis();
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "diagnosis/create";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("diagnosis") Diagnosis diagnosis, BindingResult result, Principal principal) throws ParseException {

        if (result.hasErrors()) {
            return "diagnosis/create";
        }

        Date currentDate = DateUtils.getCurrentDate();
        diagnosis.setEntryDate(currentDate);

        String username = principal.getName();
        User user = userService.findByUserName(username);
        Utils.updatePersistentProperties(diagnosis, user);

        diagnosisService.saveDiagnosis(diagnosis);

        // TODO: gotta redirect to patient record display page
        return "redirect:/home";
    }
}
