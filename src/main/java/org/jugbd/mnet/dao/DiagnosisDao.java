package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mushfekur Rahman (mushfek0001)
 */
@Repository
public interface DiagnosisDao extends JpaRepository<Diagnosis, Long> {
    //TODO revisit
    //@Query("SELECT d FROM Diagnosis d WHERE d.patient.id=:patientId AND d.admissionInfo.id=:admissionId")
    //List<Diagnosis> getDiagnosisList(@Param("patientId") Long patientId, @Param("admissionId") Long admissionId);
}
