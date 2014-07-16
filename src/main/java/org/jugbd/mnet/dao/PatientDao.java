package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.Patient;

import java.util.List;

/**
 * @author ronygomes
 */
public interface PatientDao extends GenericDao<Patient, Long> {

    public List<Patient> findByHealthIdOrPhoneNumber(String healthId, String phoneNumber);

    public List<Patient> findAll(int firstResult, int sizeNo);
}
