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
public interface PatientDao extends GenericDao<Patient, Long> {

    public List<Patient> findByHealthIdOrPhoneNumber(String healthId, String phoneNumber);

    public List<Patient> findAll(int firstResult, int sizeNo);
}
