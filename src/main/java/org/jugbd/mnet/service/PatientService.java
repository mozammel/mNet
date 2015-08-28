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

    Patient create(Patient patient);

    Patient findOne(Long id);

    List<Patient> findAll();

    Page findPatientBySearchCmd(final PatientSearchCmd searchCmd, Pageable pageable);

    Page<Patient> findAll(Pageable pageable);

    long count();

    void update(Patient patient);
}
