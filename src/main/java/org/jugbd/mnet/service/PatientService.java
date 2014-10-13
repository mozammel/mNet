package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author ronygomes
 */
public interface PatientService {

    public Patient create(Patient patient);

    public Patient findOne(Long id);

    public List<Patient> findAll();

    public List<Patient> findByHealthIdOrPhoneNumber(String healthId, String phoneNumber);

    Page<Patient> findAll(Pageable pageable);

    public long count();

    public void update(Patient patient);
}
