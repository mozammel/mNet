package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author ronygomes
 */
@Repository
public interface PatientDao extends JpaRepository<Patient, Long>, JpaSpecificationExecutor {
}
