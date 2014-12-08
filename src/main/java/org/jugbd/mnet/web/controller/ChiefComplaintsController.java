package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.domain.ChiefComplaint;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.service.ChiefComplaintService;
import org.jugbd.mnet.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @author Bazlur Rahman Rokon
 * @date 11/29/2014.
 */
@Controller
@RequestMapping("chiefcomplaints")
public class ChiefComplaintsController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private ChiefComplaintService chiefComplaintService;

    @RequestMapping(value = "create/{registerId}", method = RequestMethod.GET)
    public String create(@PathVariable Long registerId, ChiefComplaint chiefComplaint) {
        Register register = registerService.findOne(registerId);

        if (register.getChiefComplaint() != null) {
            throw new RuntimeException("chief complaints has been recorded already ");
        }

        chiefComplaint.setRegister(register);
        return "chiefcomplaints/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String save(@Valid ChiefComplaint chiefComplaint, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            return "chiefcomplaints/create";
        }

        ChiefComplaint savedChiefComplaint = chiefComplaintService.save(chiefComplaint);

        redirectAttributes.addFlashAttribute("message", "Chief Complaint successfully created");
        return "redirect:/patient/show/" + savedChiefComplaint.getRegister().getPatient().getId();
    }


    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Long id, Model uiModel) {
        ChiefComplaint chiefComplaint = chiefComplaintService.findOne(id);

        uiModel.addAttribute("chiefComplaint", chiefComplaint);

        return "chiefcomplaints/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String update(@Valid ChiefComplaint chiefComplaint,
                         BindingResult result,
                         RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {

            return "chiefcomplaints/edit";
        }

        ChiefComplaint savedChiefComplaint = chiefComplaintService.save(chiefComplaint);

        redirectAttributes.addFlashAttribute("message", "Chief Complaints successfully updated");
        return "redirect:/patient/show/" + savedChiefComplaint.getRegister().getPatient().getId();
    }

    @RequestMapping(value = "cancel/{registerId}", method = RequestMethod.GET)
    public String cancel(@PathVariable Long registerId) {

        return "redirect:/patient/show/" + registerService.findOne(registerId).getPatient().getId();
    }

}
