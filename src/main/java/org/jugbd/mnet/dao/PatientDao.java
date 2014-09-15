package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ronygomes
 */
@Repository
public interface PatientDao extends JpaRepository<Patient, Long> {

    @Query("SELECT p from Patient p WHERE healthId = (:healthId) or contactNumber = (:contactNumber)")
    public List<Patient> findByHealthIdOrPhoneNumber(@Param("healthId") String healthId, @Param("contactNumber") String phoneNumber);
}
