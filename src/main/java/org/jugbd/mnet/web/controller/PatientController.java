package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.domain.Patient;
import org.jugbd.mnet.domain.User;
import org.jugbd.mnet.domain.enums.Gender;
import org.jugbd.mnet.domain.enums.Relationship;
import org.jugbd.mnet.service.PatientService;
import org.jugbd.mnet.service.UserService;
import org.jugbd.mnet.utils.Utils;
import org.jugbd.mnet.web.editor.GenderEditor;
import org.jugbd.mnet.web.editor.RelationshipEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ronygomes
 */
@Controller
@RequestMapping("/patient")
public class PatientController {
    private static final Logger log = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private PatientService patientService;

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Gender.class, new GenderEditor());
        binder.registerCustomEditor(Relationship.class, new RelationshipEditor());
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model map) {
        Patient patient = new Patient();
        map.addAttribute("patient", patient);
        return "patient/create";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute Patient patient,
                       BindingResult result,
                       Principal principal,
                       RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            log.info("Binding Error: " + patient);
            return "patient/create";
        }

        boolean isNew = Utils.isNew(patient);

        User currentUser = userService.findByUserName(principal.getName());

        Utils.updatePersistentProperties(patient, currentUser);

        patientService.create(patient);

        redirectAttributes.addFlashAttribute("message",
                String.format("Patient successfully %s", isNew ? "created" : "updated"));
        return "redirect:/patient/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Long id, Model map) {
        Patient selectedPatient = patientService.findOne(id);
        map.addAttribute("patient", selectedPatient);
        return "patient/create";
    }

    @RequestMapping(value = {"/", "/index", "/list"}, method = RequestMethod.GET)
    public String index(Model map) {
        List<Patient> patients = patientService.findAll();
        map.addAttribute("patients", patients);
        return "patient/index";
    }
}
