package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.Patient;
import org.springframework.stereotype.Repository;

/**
 * @author ronygomes
 */
@Repository
public class PatientDaoImpl extends GenericDaoImpl<Patient, Long> implements PatientDao {
}
