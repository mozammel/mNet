package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.PatientDao;
import org.jugbd.mnet.domain.Patient;
import org.jugbd.mnet.domain.Patient_;
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

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author ronygomes
 */

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private static final Logger log = LoggerFactory.getLogger(PatientServiceImpl.class);

    @Autowired
    private PatientDao patientDao;

    @Override
    public Patient create(Patient patient) {
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

    public Page<Patient> findPatientBySearchCmd(final PatientSearchCmd searchCmd, Pageable pageable) {

        return patientDao.findAll(new Specification<Patient>() {
            @Override
            public Predicate toPredicate(Root<Patient> personRoot, CriteriaQuery<?> query, CriteriaBuilder cb) {

                Predicate predicate = cb.disjunction();

                if (StringUtils.isNotEmpty(searchCmd.getHealthId())) {
                    predicate.getExpressions()
                            .add(cb.or(cb.like(cb.upper(personRoot.get(Patient_.healthId)), getLikePattern(searchCmd.getHealthId().trim().toUpperCase()))));
                }

                if (StringUtils.isNotEmpty(searchCmd.getPhoneNumber())) {
                    predicate.getExpressions()
                            .add(cb.or(cb.equal(personRoot.get(Patient_.contactNumber), searchCmd.getPhoneNumber().trim())));
                }

                if (StringUtils.isNotEmpty(searchCmd.getName())) {
                    predicate.getExpressions()
                            .add(cb.or(cb.like(cb.lower(personRoot.get(Patient_.name)), getLikePattern(searchCmd.getName().trim().toLowerCase()))));
                }

                return predicate;
            }
        }, pageable);
    }

    private String getLikePattern(final String searchTerm) {
        StringBuilder pattern = new StringBuilder();
        pattern.append("%");
        pattern.append(searchTerm.toLowerCase());
        pattern.append("%");
        return pattern.toString();
    }
}
