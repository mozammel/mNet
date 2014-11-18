package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.Patient;
import org.jugbd.mnet.web.controller.PatientSearchCmd;
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

    public Page<Patient> findPatientBySearchCmd(final PatientSearchCmd searchCmd, Pageable pageable);

    Page<Patient> findAll(Pageable pageable);

    public long count();

    public void update(Patient patient);
}
