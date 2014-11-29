package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.domain.Diagnosis;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

/**
 * @author Mushfekur Rahman (mushfek0001)
 */
@Controller
@RequestMapping("/diagnosis")
public class DiagnosisController {

//    private static final Logger log = LoggerFactory.getLogger(DiagnosisController.class);
//
//    @Autowired
//    private DiagnosisService diagnosisService;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private RegisterService registerService;
//
//    @Autowired
//    private AdmissionInfoService admissionInfoService;
//
//    @Autowired
//    private PatientService patientService;
//
//    @RequestMapping(value = "/create/{registerId}", method = RequestMethod.GET)
//    public String create(@PathVariable Long registerId, Model map) {
//
//        Register register = registerService.findOne(registerId);
//        Diagnosis diagnosis = new Diagnosis();
//        diagnosis.setRegister(register);
//
//        map.addAttribute("diagnosis", diagnosis);
//
//        return "diagnosis/create";
//    }
//
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public String save(@Valid Diagnosis diagnosis,
//                       BindingResult result,
//                       RedirectAttributes redirectAttrs) throws ParseException {
//
//        if (result.hasErrors()) {
//
//            return "diagnosis/create";
//        }
//
//        diagnosisService.saveDiagnosis(diagnosis);
//
//        redirectAttrs.addFlashAttribute("message", "Diagnosis information entry created!");
//
//        return "redirect:/diagnosis/show/" + diagnosis.getId();
//    }
//
//    @RequestMapping(value = "/edit/{diagnosisId}", method = RequestMethod.GET)
//    public String edit(@PathVariable("diagnosisId") Long diagnosisId, Model map) {
//        log.info("diagnosisId={}", diagnosisId);
//
//        Diagnosis diagnosis = diagnosisService.getDiagnosis(diagnosisId);
//        map.addAttribute("diagnosis", diagnosis);
//
//        return "diagnosis/edit";
//    }
//
//    @RequestMapping(value = "/show/{diagnosisId}", method = RequestMethod.GET)
//    public String show(@PathVariable("diagnosisId") Long diagnosisId, Model map) {
//        log.info("diagnosisId={}", diagnosisId);
//
//        Diagnosis diagnosis = diagnosisService.getDiagnosis(diagnosisId);
//        map.addAttribute("diagnosis", diagnosis);
//        map.addAttribute("patientId", diagnosis.getRegister().getPatient().getId());
//
//        return "diagnosis/show";
//    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String update(@ModelAttribute Diagnosis diagnosis,
//                         BindingResult result,
//                         RedirectAttributes redirectAttributes) {
//
//        if (result.hasErrors()) {
//            return "diagnosis/create";
//        }
//
//        diagnosisService.updateDiagnosis(diagnosis);
//
//        redirectAttributes.addFlashAttribute("message", "Diagnosis information updated!");
//
//        return "redirect:/diagnosis/show/" + diagnosis.getId();
//    }
//
//    @RequestMapping(value = "/patients/{patientId}/admissions/{admissionId}/list", method = RequestMethod.GET)
//    public String view(@PathVariable("patientId") Long patientId,
//                       @PathVariable("admissionId") Long admissionId, Model map) {
//        log.info("patientId={} admissionId={}", patientId, admissionId);
//
//        List<Diagnosis> diagnosisList = diagnosisService.getDiagnosisList(patientId, admissionId);
//        map.addAttribute("diagnosisList", diagnosisList);
//
//        return "diagnosis/list";
//    }
}
