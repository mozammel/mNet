package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.Diagnosis;
import org.springframework.stereotype.Component;

/**
 * @author Mushfekur Rahman (mushfek0001)
 * on 7/15/14.
 */
@Component
public interface DiagnosisService {
    void saveDiagnosis(Diagnosis diagnosis);
}
