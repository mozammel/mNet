package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.Diagnosis;
import org.springframework.stereotype.Component;

/**
 * @author Mushfekur Rahman (mushfek0001)
 * on 7/15/14.
 */
@Component
public interface DiagnosisDao extends GenericDao<Diagnosis, Long> {
    void saveDiagnosis(Diagnosis diagnosis);
}
