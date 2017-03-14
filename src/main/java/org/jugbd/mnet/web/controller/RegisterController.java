package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.domain.*;
import org.jugbd.mnet.domain.enums.RegistrationType;
import org.jugbd.mnet.service.PatientService;
import org.jugbd.mnet.service.RegisterService;
import org.jugbd.mnet.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/14/14.
 */
@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
@RequestMapping("register")
public class RegisterController {
    private static final Logger log = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private PatientService patientService;

    @Autowired
    private RegisterService registerService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
    }

    @RequestMapping(value = "patient/{patientId}", method = RequestMethod.GET)
    public String create(@PathVariable(value = "patientId") Long patientId, Model uiModel) {

        Patient patient = patientService.findOne(patientId);
        Register register = new Register();
        register.setPatient(patient);
        uiModel.addAttribute("register", register);

        return "register/create";
    }

    @RequestMapping(value = "opd/{patientId}/new", method = RequestMethod.GET)
    public String createOutPatient(@PathVariable(value = "patientId") Long patientId, Model uiModel) {
        Patient patient = patientService.findOne(patientId);

        OutdoorRegister outdoorRegister = new OutdoorRegister();
        outdoorRegister.setPatient(patient);
        uiModel.addAttribute("outdoorRegister", outdoorRegister);

        return "register/opd";
    }

    @RequestMapping(value = "opd/save", method = RequestMethod.POST)
    public String saveOpd(@Valid OutdoorRegister outdoorRegister,
                          BindingResult result,
                          RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            return "register/opd";
        }

        registerService.save(outdoorRegister);

        return "redirect:/register/opd/" + outdoorRegister.getId();
    }

    @RequestMapping(value = "ipd/{patientId}/new", method = RequestMethod.GET)
    public String createInpatient(@PathVariable(value = "patientId") Long patientId, Model uiModel) {
        Patient patient = patientService.findOne(patientId);
        Register register = new Register();
        register.setPatient(patient);
        uiModel.addAttribute("register", register);

        return "register/ipd";
    }

    @RequestMapping(value = "ipd/save", method = RequestMethod.POST)
    public String saveInpatient(@Valid Register register,
                                BindingResult result,
                                RedirectAttributes redirectAttributes) {

        log.info("patient getAdmissionDate: {}", register.getAdmissionDate());

        if (result.hasErrors()) {

            return "register/ipd";
        }

        registerService.save(register);

        return "redirect:/register/ipd/" + register.getId();
    }

    @RequestMapping(value = "opd/{id}", method = RequestMethod.GET)
    public String openOpdRegistration(@PathVariable Long id, Model uiModel) {
        prepareData(id, RegistrationType.OUTDOOR, uiModel);

        return "register/opd-registration";
    }

    @RequestMapping(value = "ipd/{id}", method = RequestMethod.GET)
    public String openIpdRegistration(@PathVariable Long id, Model uiModel) {
        prepareData(id, RegistrationType.INDOOR, uiModel);

        return "register/ipd-registration";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@Valid Register register,
                       BindingResult result,
                       RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            return "register/create";
        }

        registerService.save(register);

        return "redirect:/patient/show/" + register.getPatient().getId();
    }

    @RequestMapping(value = "close/{registerId}", method = RequestMethod.POST)
    public String close(@PathVariable(value = "registerId") Long registerId,
                        @RequestParam RegistrationType registrationType,
                        RedirectAttributes redirectAttributes) {

        registerService.closeRegister(registerId, registrationType);
        redirectAttributes.addFlashAttribute("message", "Registration has been closed!");
        Patient patient = registerService.findRegisterEither(registerId, registrationType)
                .fold(Register::getPatient, OutdoorRegister::getPatient);

        return "redirect:/patient/show/" + patient.getId();
    }


    @RequestMapping(value = "cancel/{patientId}", method = RequestMethod.GET)
    public String cancel(@PathVariable(value = "patientId") Long patientId) {
        log.debug("cancel()");

        return "redirect:/patient/show/" + patientId;
    }

    @RequestMapping(value = "/edit/{registrationId}", method = RequestMethod.GET)
    public String editRegistration(@PathVariable Long registrationId,
                                   @RequestParam(value = "type") String type,
                                   Model uiModel) {

        if (StringUtils.isNotEmpty(type) && type.equalsIgnoreCase("opd")) {
            OutdoorRegister outdoorRegister = registerService.findOpdRegister(registrationId);
            uiModel.addAttribute("outdoorRegister", outdoorRegister);

            return "register/opd-edit";
        } else {
            Register register = registerService.findOne(registrationId);

            uiModel.addAttribute("register", register);

            return "register/ipd-edit";
        }
    }

    @RequestMapping(value = "opd/update", method = RequestMethod.POST)
    public String updateOpd(@Valid OutdoorRegister outdoorRegister,
                            BindingResult result,
                            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            return "register/opd-edit";
        }

        registerService.save(outdoorRegister);

        return "redirect:/register/opd/" + outdoorRegister.getId();
    }

    @RequestMapping(value = "ipd/update", method = RequestMethod.POST)
    public String updateRegistration(@Valid Register register) {
        Register savedRegister = registerService.save(register);

        return "redirect:/register/ipd/" + savedRegister.getId();
    }

    //Diagnosis

    @RequestMapping(value = "/diagnosis/{registerId}", method = RequestMethod.GET)
    public String diagnosis(@PathVariable Long registerId,
                            @RequestParam RegistrationType registrationType,
                            Model uiModel) {

        uiModel.addAttribute("diagnosis", registerService.findDiagnosis(registerId, registrationType));
        prepareData(registerId, registrationType, uiModel);

        return "register/diagnosis";
    }

    //Plan of Rx

    @RequestMapping(value = "/treatmentplan/{registerId}", method = RequestMethod.GET)
    public String treatmentPlan(@PathVariable Long registerId,
                                @RequestParam RegistrationType registrationType,
                                Model uiModel) {

        uiModel.addAttribute("treatmentPlan", registerService.findTreatmentPlan(registerId, registrationType));
        prepareData(registerId, registrationType, uiModel);

        return "register/treatmentplan";
    }

    //Examination

    @RequestMapping(value = "/examination/{registerId}", method = RequestMethod.GET)
    public String examination(@PathVariable Long registerId,
                              @RequestParam RegistrationType registrationType,
                              Model uiModel) {

        uiModel.addAttribute("examination", registerService.findExamination(registerId, registrationType));
        prepareData(registerId, registrationType, uiModel);

        return "register/examination";
    }

    //Cheif Complaints
    @RequestMapping(value = "/chiefcomplaints/{registerId}", method = RequestMethod.GET)
    public String chiefcomplaints(@PathVariable Long registerId,
                                  @RequestParam RegistrationType registrationType,
                                  Model uiModel) {

        uiModel.addAttribute("chiefcomplaints", registerService.findChiefcomplaints(registerId, registrationType));
        prepareData(registerId, registrationType, uiModel);

        return "register/chiefcomplaints";
    }

    //vitals
    @RequestMapping(value = "/vitals/{registerId}", method = RequestMethod.GET)
    public String vital(@PathVariable Long registerId,
                        @RequestParam RegistrationType registrationType,
                        Model uiModel) {

        uiModel.addAttribute("lastVital", registerService.getLastVital(registerId, registrationType));
        prepareData(registerId, registrationType, uiModel);

        return "register/vital";
    }

    //Visit note
    @RequestMapping(value = "/visits/{registerId}", method = RequestMethod.GET)
    public String visitNotes(@PathVariable Long registerId,
                             @RequestParam RegistrationType registrationType,
                             Model uiModel) {

        uiModel.addAttribute("visits", registerService.getVisits(registerId, registrationType));
        prepareData(registerId, registrationType, uiModel);

        return "register/visit-note";
    }

    //outcome
    @RequestMapping(value = "/outcome/{registerId}", method = RequestMethod.GET)
    public String outcome(@PathVariable Long registerId,
                          @RequestParam RegistrationType registrationType,
                          Model uiModel) {
        prepareData(registerId, registrationType, uiModel);

        return "register/outcome";
    }

    @RequestMapping(value = "/edit-outcome/{registerId}", method = RequestMethod.GET)
    public String editOutcome(@PathVariable Long registerId,
                              @RequestParam RegistrationType registrationType,
                              Model uiModel) {
        prepareData(registerId, registrationType, uiModel);
        uiModel.addAttribute("edit", true);
        uiModel.addAttribute("registerId", registerId);

        return "register/outcome";
    }

    @RequestMapping(value = "/edit-outcome/{registerId}", method = RequestMethod.POST)
    public String saveOutcome(@PathVariable Long registerId,
                              @RequestParam RegistrationType registrationType,
                              String outcome,
                              Model uiModel) {

        registerService.saveOutcome(outcome, registerId, registrationType);

        return "redirect:/register/outcome/" + registerId + "?registrationType=" + registrationType;
    }

    //Remarks
    @RequestMapping(value = "/remarks/{registerId}", method = RequestMethod.GET)
    public String remarks(@PathVariable Long registerId,
                          @RequestParam RegistrationType registrationType,
                          Model uiModel) {
        prepareData(registerId, registrationType, uiModel);

        return "register/remarks";
    }

    @RequestMapping(value = "/edit-remarks/{registerId}", method = RequestMethod.GET)
    public String editRemarks(@PathVariable Long registerId,
                              @RequestParam RegistrationType registrationType,
                              Model uiModel) {
        prepareData(registerId, registrationType, uiModel);
        uiModel.addAttribute("edit", true);
        uiModel.addAttribute("registerId", registerId);

        return "register/remarks";
    }

    @RequestMapping(value = "/edit-remarks/{registerId}", method = RequestMethod.POST)
    public String saveRemarks(@PathVariable Long registerId,
                              @RequestParam RegistrationType registrationType,
                              String remarks,
                              Model uiModel) {

        registerService.saveRemarks(remarks, registerId, registrationType);

        return "redirect:/register/remarks/" + registerId + "?registrationType=" + registrationType;
    }

    // Convert OPD to IPD

    @RequestMapping(value = "/convert-to-ipd/{registerId}", method = RequestMethod.GET)
    public String convert(@PathVariable Long registerId,
                          @RequestParam RegistrationType registrationType,
                          Model uiModel) {

        OutdoorRegister outdoorRegister = registerService.findOpdRegister(registerId);

        Register register = new Register();
        register.setRegistrationId(outdoorRegister.getRegistrationId());
        register.setPatientContact(outdoorRegister.getPatientContact());
        register.setPatient(outdoorRegister.getPatient());

        uiModel.addAttribute("register", register);
        uiModel.addAttribute("registerId", registerId);

        return "register/convert";
    }

    @RequestMapping(value = "/convert-to-ipd/{registerId}", method = RequestMethod.POST)
    public String completeConversion(@PathVariable Long registerId,
                                     @Valid Register register,
                                     BindingResult result,
                                     Model uiModel) {
        if (result.hasErrors()) {
            uiModel.addAttribute("registerId", registerId);

            return "register/convert";
        }

        Register savedRegister = registerService.convertOutdoorRegisterToIndoorRegister(registerId, register);

        return "redirect:/patient/show/" + savedRegister.getPatient().getId();
    }

    @RequestMapping(value = "/medicalhistory/{registerId}", method = RequestMethod.GET)
    public String pastMedicalHistory(@PathVariable Long registerId, Model uiModel) {
        prepareData(registerId, RegistrationType.INDOOR, uiModel);

        return "register/medical-history";
    }

    @RequestMapping(value = "/operationaldetail/{registerId}", method = RequestMethod.GET)
    public String operationalDetails(@PathVariable Long registerId, Model uiModel) {
        prepareData(registerId, RegistrationType.INDOOR, uiModel);
        Set<OperationalDetail> detailList = registerService.findOperationalDetailList(registerId);

        uiModel.addAttribute("operationaldetails", detailList);

        return "register/operational-detail";
    }

    @RequestMapping(value = "/investigation/{registerId}", method = RequestMethod.GET)
    public String investigation(@PathVariable Long registerId, Model uiModel) {
        prepareData(registerId, RegistrationType.INDOOR, uiModel);
        Set<Investigation> investigations = registerService.findInvestigations(registerId);

        uiModel.addAttribute("investigations", investigations);

        return "register/investigation";
    }

    //complicationmanagement
    @RequestMapping(value = "/complicationmanagement/{registerId}", method = RequestMethod.GET)
    public String complicationmanagement(@PathVariable Long registerId, Model uiModel) {
        prepareData(registerId, RegistrationType.INDOOR, uiModel);

        return "register/complicationmanagement";
    }

    @RequestMapping(value = "/lifestyle/{registerId}", method = RequestMethod.GET)
    public String lifeStyle(@PathVariable Long registerId, Model uiModel) {
        prepareData(registerId, RegistrationType.INDOOR, uiModel);

        return "register/life-style";
    }

    @RequestMapping(value = "/picture/{registerId}", method = RequestMethod.GET)
    public String pictureInformation(@PathVariable Long registerId, Model uiModel) {
        prepareData(registerId, RegistrationType.INDOOR, uiModel);

        return "register/picture";
    }

    private void prepareData(@PathVariable Long registerId, RegistrationType registrationType, Model uiModel) {
        uiModel.addAttribute("register", registerService.findRegister(registerId, registrationType));
        uiModel.addAttribute("registrationType", registrationType);

        Patient patient = registerService.findRegisterEither(registerId, registrationType)
                .fold(Register::getPatient, OutdoorRegister::getPatient);

        uiModel.addAttribute("patient", patient);
    }
}

