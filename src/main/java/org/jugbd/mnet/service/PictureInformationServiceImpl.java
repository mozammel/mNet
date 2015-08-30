package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.AttachmentDao;
import org.jugbd.mnet.dao.PictureInformationDao;
import org.jugbd.mnet.domain.Attachment;
import org.jugbd.mnet.domain.PictureInformation;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.domain.enums.PictureInformationType;
import org.jugbd.mnet.utils.FileUtils;
import org.jugbd.mnet.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/27/14.
 */
@Service
@Transactional
public class PictureInformationServiceImpl implements PictureInformationService {
    private Logger log = LoggerFactory.getLogger(PictureInformationService.class);

    @Autowired
    private RegisterService registerService;

    @Autowired
    private PictureInformationDao pictureInformationDao;

    @Autowired
    private AttachmentDao attachmentDao;

    @Override
    public PictureInformation save(PictureInformation pictureInformation) {
        if (pictureInformation.getId() == null) {

        } else {

        }

        return null;
    }

    @Override
    public PictureInformation findOne(Long id) {
        return null;
    }

    public ResponseEntity<byte[]> getUploadedFileAsResponseEntity(Long fileId) {
        Attachment attachment = attachmentDao.findOne(fileId);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", attachment.getMimeType());
        /*
        'inline' attribute in Content-Disposition instruct browser to display content of file if possible otherwise show user
        to download file. Spring's headers.setContentDispositionFormData((String name, String filename) won't work in this way.
        Because it set http header something like: Content-Disposition:form-data; name="inline"; filename="file.pdf"
        So, browser always display file download box. But if header set as following way, http header become:
                Content-Disposition:inline; filename=file.pdf
        which works perfectly to display images/pdf in browser.
         */
        headers.set("Content-Disposition", "inline; filename=" + attachment.getFileName());

        return new ResponseEntity<>(attachment.getData(), headers, HttpStatus.OK);
    }

    @Override
    public PictureInformation findPictureInformationByRegistrationId(Long registerId) {

        PictureInformation pictureInformation = pictureInformationDao.findPictureInformationByRegister_Id(registerId);

        if (pictureInformation == null) {
            pictureInformation = new PictureInformation();
            Register register = registerService.findOne(registerId);
            pictureInformation.setRegister(register);
        }

        //TODO need to revisit this later, quick fix for now
        pictureInformation.getDayOneAttachments().removeIf(Attachment::isDeleted);
        pictureInformation.getOnDischargeAttachments().removeIf(Attachment::isDeleted);
        pictureInformation.getPostOperativeAttachments().removeIf(Attachment::isDeleted);
        pictureInformation.getPreOperationAttachments().removeIf(Attachment::isDeleted);
        pictureInformation.getPreOperativeAttachments().removeIf(Attachment::isDeleted);

        return pictureInformation;
    }

    @Override
    public void upload(Long registerId, MultipartFile file, PictureInformationType pictureInformationType, String fileName, String comment) {
        log.info("upload()");

        try {
            Attachment attachment = createAttachment(file, fileName, comment);

            Register resister = registerService.findOne(registerId);
            PictureInformation pictureInformation = resister.getPictureInformation();

            if (pictureInformation == null) {

                pictureInformation = new PictureInformation();
            }

            switch (pictureInformationType) {
                case DAY_ONE:
                    pictureInformation.getDayOneAttachments().add(attachment);
                    break;

                case PREOPERATIVE:
                    pictureInformation.getPreOperativeAttachments().add(attachment);
                    break;

                case PRE_OPERATION:
                    pictureInformation.getPreOperationAttachments().add(attachment);
                    break;

                case POSTOPERATIVE:
                    pictureInformation.getPostOperativeAttachments().add(attachment);
                    break;

                case ON_DISCHARGE:
                    pictureInformation.getOnDischargeAttachments().add(attachment);
                    break;
                default:
                    //do nothing
                    break;
            }

            pictureInformation.setRegister(resister);
            PictureInformation savedPictureInformation = pictureInformationDao.save(pictureInformation);

            resister.setPictureInformation(savedPictureInformation);
            registerService.save(resister);

        } catch (IOException e) {
            log.error("unable to create attachment", e);
        }
    }

    public Attachment createAttachment(MultipartFile file, String fileName, String comment) throws IOException {
        log.info("createAttachment, name={}, originalName={}", file.getName(), file.getOriginalFilename());

        Attachment attachment = new Attachment();

        attachment.setData(file.getBytes());

        if (StringUtils.isNotEmpty(fileName)) {
            attachment.setFileName(fileName);
        } else {
            attachment.setFileName(FileUtils.getFilteredFileName(file.getOriginalFilename()));
        }
        attachment.setMimeType(FileUtils.getContentType(FileUtils.getExtensionInLowerCase(FileUtils.getFilteredFileName(file.getOriginalFilename()))));
        attachment.setComment(comment);

        return attachment;
    }
}
