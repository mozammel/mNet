package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.AdmissionInfo;
import org.springframework.stereotype.Component;

/**
 * @author raqibul
 * @since 7/16/14 6:30 PM
 */
@Component
public interface AdmissionInfoService {
    public void save(AdmissionInfo admissionInfo);

    AdmissionInfo findOne(Long id);

}
