package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.dao.AttachmentDao;
import org.jugbd.mnet.domain.Attachment;
import org.jugbd.mnet.domain.PictureInformation;
import org.jugbd.mnet.domain.enums.PictureInformationType;
import org.jugbd.mnet.service.PictureInformationService;
import org.jugbd.mnet.service.RegisterService;
import org.jugbd.mnet.utils.Contestant;
import org.jugbd.mnet.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/27/14.
 */
@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
public class PictureInformationController {
    private Logger log = LoggerFactory.getLogger(PictureInformationController.class);

    @Autowired
    private RegisterService registerService;

    @Autowired
    private PictureInformationService pictureInformationService;

    @Autowired
    private AttachmentDao attachmentDao;

    @RequestMapping(value = "picture/{registerId}", method = RequestMethod.GET)
    public String show(@PathVariable Long registerId, Model uiModel) {

        PictureInformation pictureInformation = pictureInformationService.findPictureInformationByRegistrationId(registerId);

        uiModel.addAttribute("pictureInformation", pictureInformation);
        uiModel.addAttribute("register", pictureInformation.getRegister());

        return "picture/show";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadPhoto(@RequestParam("file") MultipartFile file,
                              @RequestParam("pictureInformationType") PictureInformationType pictureInformationType,
                              @RequestParam("fileName") String fileName,
                              @RequestParam("comment") String comment,
                              @RequestParam("registerId") Long registerId,
                              RedirectAttributes redirectAttributes
    ) throws IOException {
        log.debug("uploadPhoto() pictureInformationType ={}", pictureInformationType);

        String errorMsg = validate(file, Contestant.VALID_FILE_TYPE_LIST, Contestant.FILE_MAX_SIZE_BYTES, "Photo");

        if (!errorMsg.isEmpty()) {

            redirectAttributes.addFlashAttribute("error", errorMsg);
            return "picture/show";
        }

        pictureInformationService.upload(registerId, file, pictureInformationType, fileName, comment);
        redirectAttributes.addFlashAttribute("message", "File successfully uploaded");

        return "redirect:/picture/" + registerId;
    }

    @RequestMapping(value = "picture/delete/{registerId}/{attachmentId}", method = RequestMethod.POST)
    public String remove(@PathVariable Long registerId, @PathVariable Long attachmentId) {

        Attachment attachment = attachmentDao.findOne(attachmentId);
        attachment.setDeleted(true);

        attachmentDao.save(attachment);

        return "redirect:/picture/" + registerId;
    }

    private String validate(MultipartFile file, String[] validFileTypes, int maxFileSize, String field) {
        if (!FileUtils.isValidFile(file, validFileTypes)) {
            return String.format("Please make sure your %s is in valid format", field);
        } else if (file.getSize() > maxFileSize) {
            return String.format("%s size exceeded maximum size of 3MB", field);
        } else {
            return "";
        }
    }

    @RequestMapping(value = "/file/{attachmentId}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getContestantPhoto(@PathVariable Long attachmentId) throws IOException {

        return pictureInformationService.getUploadedFileAsResponseEntity(attachmentId);
    }

    @RequestMapping(value = "cancel/{registerId}", method = RequestMethod.GET)
    public String cancel(@PathVariable Long registerId) {

        return "redirect:/register/picture/" + registerId;
    }
}
