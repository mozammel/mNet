package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.PictureInformation;
import org.jugbd.mnet.domain.enums.PictureInformationType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/27/14.
 */

@Component
public interface PictureInformationService {
    PictureInformation save(PictureInformation pictureInformation);

    PictureInformation findOne(Long id);

    void upload(Long registerId, MultipartFile file, PictureInformationType pictureInformationType, String fileName, String comment);

    ResponseEntity<byte[]> getUploadedFileAsResponseEntity(Long fileId);
}
