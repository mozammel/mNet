package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author ronygomes
 */

@Repository
public class PatientDaoImpl extends GenericDaoImpl<Patient, Long> implements PatientDao {
    private static final Logger log = LoggerFactory.getLogger(PatientDaoImpl.class);

    public List<Patient> findByHealthIdOrPhoneNumber(String healthId, String phoneNumber) {
        log.debug("findByHealthIdOrPhoneNumber() healthId={}, phoneNumber ={}", healthId, phoneNumber);

        String sql = "SELECT p from Patient p WHERE healthId = (:healthId) or contactNumber = (:contactNumber)";
        TypedQuery<Patient> query = entityManager.createQuery(sql, Patient.class);
        query.setParameter("healthId", healthId);
        query.setParameter("contactNumber", phoneNumber);

        return query.getResultList();
    }

    @Override
    public List<Patient> findAll(int firstResult, int sizeNo) {
        log.debug("findAll() firstResult={},sizeNo={}", firstResult, sizeNo);

        TypedQuery<Patient> query = entityManager.createQuery("from Patient", Patient.class);
        query.setMaxResults(sizeNo);
        query.setFirstResult(firstResult);

        return query.getResultList();
    }
}
