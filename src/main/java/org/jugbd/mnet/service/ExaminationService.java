package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.Diagnosis;
import org.jugbd.mnet.domain.Examination;
import org.jugbd.mnet.domain.enums.RegistrationType;
import org.springframework.stereotype.Component;

/**
 * @author Bazlur Rahman Rokon
 * @date 11/29/2014.
 */
@Component
public interface ExaminationService {
    Examination save(Examination examination);

    Examination findOne(Long id);

    Examination save(Examination examination, RegistrationType registrationType);
}
