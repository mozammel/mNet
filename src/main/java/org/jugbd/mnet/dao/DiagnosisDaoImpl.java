package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.Diagnosis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Mushfekur Rahman (mushfek0001)
 */
@Repository
public class DiagnosisDaoImpl extends GenericDaoImpl<Diagnosis, Long> implements DiagnosisDao {

    private static final Logger log = LoggerFactory.getLogger(DiagnosisDaoImpl.class);

    @Override
    public void saveDiagnosis(Diagnosis diagnosis) {
        log.info("diagnosis={}", diagnosis);

        save(diagnosis);
    }

    @Override
    public Diagnosis getDiagnosis(Long diagnosisId) {
        log.info("diagnosisId={}", diagnosisId);

        return findOne(diagnosisId);
    }

    @Override
    public List<Diagnosis> getDiagnosisList(Long patientId, Long admissionId) {
        log.info("patientId={} admissionId={}", patientId, admissionId);

        String queryString = "SELECT d FROM Diagnosis d" +
                " WHERE d.patient.id=:patientId" +
                " AND d.admissionInfo.id=:admissionId";
        TypedQuery<Diagnosis> query = entityManager.createQuery(queryString, Diagnosis.class);
        query.setParameter("patientId", patientId);
        query.setParameter("admissionId", admissionId);

        return query.getResultList();
    }
}
