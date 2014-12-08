package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.MedicalHistory;
import org.springframework.stereotype.Component;

/**
 * @author Bazlur Rahman Rokon
 * @date 11/28/2014.
 */
@Component
public interface MedicalHistoryService {
    MedicalHistory save(MedicalHistory medicalHistory);

    MedicalHistory findOne(Long id);

}
