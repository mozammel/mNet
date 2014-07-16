package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.Diagnosis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Mushfekur Rahman (mushfek0001)
 * on 7/15/14.
 */
@Repository
public class DiagnosisDaoImpl extends GenericDaoImpl<Diagnosis, Long> implements DiagnosisDao {

    private static final Logger log = LoggerFactory.getLogger(DiagnosisDaoImpl.class);

    @Override
    public void saveDiagnosis(Diagnosis diagnosis) {
        log.info("diagnosis={}", diagnosis);

        save(diagnosis);
    }
}
