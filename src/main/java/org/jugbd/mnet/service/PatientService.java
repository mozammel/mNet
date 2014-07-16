package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.Patient;

import java.util.List;

/**
 * @author ronygomes
 */
public interface PatientService {

    public Patient create(Patient patient);

    public Patient findOne(Long id);

    public List<Patient> findAll();
}

