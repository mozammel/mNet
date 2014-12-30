package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.domain.OperationalDetail;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.domain.enums.Gender;
import org.jugbd.mnet.domain.enums.Relationship;
import org.jugbd.mnet.service.OperationalDetailService;
import org.jugbd.mnet.service.RegisterService;
import org.jugbd.mnet.web.editor.GenderEditor;
import org.jugbd.mnet.web.editor.RelationshipEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/26/14.
 */
@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
@RequestMapping("operationaldetail")
public class OperationalDetailController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private OperationalDetailService operationalDetailService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("MM/dd/yyyy hh:mm a"), true));
    }

    @RequestMapping(value = "create/{registerId}", method = RequestMethod.GET)
    public String create(@PathVariable Long registerId, OperationalDetail operationalDetail, Model uiModel) {

        Register register = registerService.findOne(registerId);
        operationalDetail.setRegister(register);

        return "operationaldetail/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String save(@Valid OperationalDetail operationalDetail,
                       BindingResult result,
                       RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            return "operationaldetail/create";
        }

        OperationalDetail operationalDetailSaved = operationalDetailService.save(operationalDetail);
        redirectAttributes.addFlashAttribute("message", "Operational Detail successfully created");

        return "redirect:/operationaldetail/show/" + operationalDetailSaved.getId();
    }

    @RequestMapping(value = "show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Long id, Model uiModel) {
        OperationalDetail operationalDetail = operationalDetailService.findOne(id);
        uiModel.addAttribute("operationalDetail", operationalDetail);

        return "operationaldetail/show";
    }


    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Long id, Model uiModel) {
        OperationalDetail operationalDetail = operationalDetailService.findOne(id);
        uiModel.addAttribute("operationalDetail", operationalDetail);

        return "operationaldetail/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String update(@Valid OperationalDetail operationalDetail,
                         BindingResult result,
                         RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            return "operationaldetail/edit";
        }

        OperationalDetail operationalDetailSaved = operationalDetailService.save(operationalDetail);
        redirectAttributes.addFlashAttribute("message", "Operational Detail successfully updated");

        return "redirect:/operationaldetail/show/" + operationalDetailSaved.getId();
    }

    @RequestMapping(value = "cancel/{registerId}", method = RequestMethod.GET)
    public String cancel(@PathVariable Long registerId) {

        return "redirect:/patient/show/" + registerService.findOne(registerId).getPatient().getId();
    }
}
