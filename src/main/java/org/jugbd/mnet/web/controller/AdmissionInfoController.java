package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.domain.AdmissionInfo;
import org.jugbd.mnet.domain.Patient;
import org.jugbd.mnet.service.AdmissionInfoService;
import org.jugbd.mnet.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author raqibul
 * @since 7/16/14 6:17 PM
 */
@Controller
@RequestMapping("/admissionInfo")
public class AdmissionInfoController {

    @Autowired
    private AdmissionInfoService admissionInfoService;

    @Autowired
    private PatientService patientService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
    }

    public String index() {
        return "admissionInfo/index";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(@RequestParam(value = "patientId", required = true) Long patientId, Model uiModel) {
        Patient patient = patientService.findOne(patientId);
        AdmissionInfo admissionInfo = new AdmissionInfo();
        //admissionInfo.setPatient(patient);

        uiModel.addAttribute("admissionInfo", admissionInfo);

        return "admissionInfo/create";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("admissionInfo") AdmissionInfo admissionInfo, BindingResult result) {
        if (result.hasErrors()) {
            return "admissionInfo/create";
        }

        admissionInfoService.save(admissionInfo);
        //return "redirect:/patient/show/" + admissionInfo.getPatient().getId().toString();
        return "";
    }

    @RequestMapping(value = "show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model model) {

        AdmissionInfo admissionInfo = admissionInfoService.findOne(id);
        model.addAttribute("admissionInfo", admissionInfo);

        return "admissionInfo/show";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Model uiModel) {
        AdmissionInfo admissionInfo = admissionInfoService.findOne(id);
        uiModel.addAttribute("admissionInfo", admissionInfo);

        return "admissionInfo/edit";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("admissionInfo") AdmissionInfo admissionInfo, BindingResult result) {
        if (result.hasErrors()) {
            return "admissionInfo/edit";
        }

        admissionInfoService.save(admissionInfo);
        //return "redirect:/admissionInfo/show/" + admissionInfo.getId().toString();
        return null;
    }
}
