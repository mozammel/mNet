package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.PatientDao;
import org.jugbd.mnet.domain.Patient;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.utils.PatientIdGenerator;
import org.jugbd.mnet.utils.StringUtils;
import org.jugbd.mnet.web.controller.PatientSearchCmd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author ronygomes
 */

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientServiceImpl.class);

    @Autowired
    private PatientDao patientDao;

    @Override
    public Patient create(Patient patient) {
        LOGGER.debug("creating new patient with info : {}", patient);

        patient.setHealthId(PatientIdGenerator.generate(patient.getAddress()));

        if (patient.getDateOfBirth() == null) {
            patient.setBirthdateFromAge(patient.getAge(), null);
        }

        return patientDao.save(patient);
    }

    @Override
    public Patient findOne(Long id) {

        return patientDao.findOne(id);
    }

    @Override
    public List<Patient> findAll() {

        return patientDao.findAll();
    }

    @Override
    public Page<Patient> findAll(Pageable pageable) {

        return patientDao.findAll(pageable);
    }

    @Override
    public long count() {

        return patientDao.count();
    }

    @Override
    public void update(Patient patient) {
        LOGGER.debug("Updating patient with info : {}", patient);

        Patient patientFromDb = findOne(patient.getId());

        patientFromDb.setName(patient.getName());
        patientFromDb.setDateOfBirth(patient.getDateOfBirth());
        patientFromDb.setGender(patient.getGender());
        patientFromDb.setBloodType(patient.getBloodType());
        patientFromDb.setContactNumber(patient.getContactNumber());
        patientFromDb.setAddress(patient.getAddress());
        patientFromDb.setDead(patient.getDead());
        patientFromDb.setDeathDate(patient.getDeathDate());
        patientFromDb.setBirthdateEstimated(patient.getBirthdateEstimated());
        patientFromDb.setNid(patient.getNid());
        patientFromDb.setMaritalStatus(patient.getMaritalStatus());
        patientFromDb.setOccupation(patient.getOccupation());
        patientFromDb.setEducationLevel(patient.getEducationLevel());
        patientFromDb.setBirthdateEstimated(patient.getBirthdateEstimated());

        patientDao.save(patientFromDb);
    }

    /*
    * SELECT patient0_
    *
    *FROM patient patient0_
    *WHERE upper(patient0_.health_id) LIKE ? OR patient0_.contact_number = ? OR lower(patient0_.name) LIKE ? OR
    *  patient0_.id = (SELECT patient2_.id
    *                  FROM register register1_ INNER JOIN patient patient2_ ON register1_.patient = patient2_.id
    *                  WHERE register1_.registration_id = ?)
    *LIMIT ?
    */
    public Page findPatientBySearchCmd(final PatientSearchCmd searchCmd, Pageable pageable) {
        LOGGER.debug("finding patient information with info : {}", searchCmd);

        return patientDao.findAll((patientRoot, query, cb) -> {

            Predicate predicate = cb.disjunction();

            if (StringUtils.isNotEmpty(searchCmd.getHealthId())) {
                predicate
                        .getExpressions()
                        .add(cb.or(cb.like(cb.upper(patientRoot.<String>get("healthId")),
                                getLikePattern(searchCmd.getHealthId()
                                        .trim()
                                        .toUpperCase()))));
            }

            if (StringUtils.isNotEmpty(searchCmd.getPhoneNumber())) {
                predicate
                        .getExpressions()
                        .add(cb.or(cb.equal(patientRoot.get("contactNumber"), searchCmd.getPhoneNumber().trim())));
            }

            if (StringUtils.isNotEmpty(searchCmd.getName())) {
                predicate
                        .getExpressions()
                        .add(cb.or(cb.like(cb.lower(patientRoot.<String>get("name")),
                                getLikePattern(searchCmd.getName()
                                        .trim()
                                        .toLowerCase()))));
            }

            if (StringUtils.isNotEmpty(searchCmd.getRegisterId())){

                Subquery<Patient> sq = query.subquery(Patient.class);
                Root<Register> project = sq.from(Register.class);
                Join<Register, Patient> sqEmp = project.join("patient");
                sq.select(sqEmp).where(cb.equal(project.get("registrationId"), searchCmd.getRegisterId()));
                predicate.getExpressions().add(cb.or (cb.equal((patientRoot.get("id")), sq)));
            }

            return predicate;
        }, pageable);
    }

    private String getLikePattern(String searchTerm) {

        return "%" + searchTerm.toLowerCase() + "%";
    }
}
