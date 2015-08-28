package org.jugbd.mnet.service;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import org.jugbd.mnet.dao.PatientDao;
import org.jugbd.mnet.domain.Patient;
import org.jugbd.mnet.domain.enums.Condition;
import org.jugbd.mnet.utils.PatientIdGenerator;
import org.jugbd.mnet.utils.StringUtils;
import org.jugbd.mnet.web.controller.PatientSearchCmd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.jugbd.mnet.domain.QDiagnosis.diagnosis;
import static org.jugbd.mnet.domain.QDiagnosisData.diagnosisData;
import static org.jugbd.mnet.domain.QPatient.patient;
import static org.jugbd.mnet.domain.QRegister.register;

/**
 * @author ronygomes
 */

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientServiceImpl.class);

    @Autowired
    private PatientDao patientDao;

    @PersistenceContext
    private EntityManager em;

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

    public Page findPatientBySearchCmd(final PatientSearchCmd searchCmd, Pageable pageable) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (StringUtils.isNotEmpty(searchCmd.getHealthId())) {
            predicate.or(patient.healthId.like(getLikePattern(searchCmd.getHealthId().trim())));
        }

        if (StringUtils.isNotEmpty(searchCmd.getPhoneNumber())) {
            predicate.or(patient.contactNumber.like(getLikePattern(searchCmd.getPhoneNumber().trim())));
            predicate.or(register.patientContact.emergencyContactNumber.like(getLikePattern(searchCmd.getPhoneNumber().trim())));
        }

        if (StringUtils.isNotEmpty(searchCmd.getRegisterId())) {
            predicate.or(register.registrationId.eq(searchCmd.getRegisterId().trim()));
        }

        if (StringUtils.isNotEmpty(searchCmd.getName())) {
            predicate.or(patient.name.like(getLikePattern(searchCmd.getName())));
        }

        if (StringUtils.isNotEmpty(searchCmd.getDiagnosis())) {
            predicate.or(diagnosis.congenitalAnomaly.like(getLikePattern(searchCmd.getDiagnosis())));
            predicate.or(diagnosis.neoplastic.like(getLikePattern(searchCmd.getDiagnosis())));
            predicate.or(diagnosis.postInfective.like(getLikePattern(searchCmd.getDiagnosis())));
            predicate.or(diagnosis.traumatic.like(getLikePattern(searchCmd.getDiagnosis())));
            predicate.or(diagnosis.aesthetic.like(getLikePattern(searchCmd.getDiagnosis())));
            predicate.or(diagnosis.comment.like(getLikePattern(searchCmd.getDiagnosis())));
            predicate.or(diagnosis.icd10.like(getLikePattern(searchCmd.getDiagnosis())));
            Condition condition = getCondition(searchCmd.getDiagnosis());
            if (condition != null) {
                predicate.or(diagnosis.burns.conditions.eq(condition));
            }
        }

        JPAQuery from = new JPAQuery(em)
                .from(patient)
                .join(patient.registers, register)
                .join(register.diagnosis, diagnosis)
                .join(diagnosis.burns, diagnosisData);

        long count = from.distinct().where(predicate).count();
        List<Patient> patients = applyPagination(from, pageable)
                .orderBy(patient.name.asc())
                .distinct()
                .list(patient);

        return count > 0 ? new PageImpl<>(patients, pageable, count) : new PageImpl<>(new ArrayList<>(), pageable, 0);
    }

    protected JPQLQuery applyPagination(JPQLQuery query, Pageable pageable) {

        return pageable != null ? query.offset(pageable.getOffset()).limit(pageable.getPageSize()) : query;
    }

    private Condition getCondition(String value) {

        return Arrays.asList(Condition.values())
                .stream()
                .filter(condition -> condition.getLabel().toLowerCase().contains(value.toLowerCase()))
                .findFirst()
                .map(condition -> condition)
                .orElse(null);
    }

    private String getLikePattern(String searchTerm) {

        return "%" + searchTerm.toLowerCase() + "%";
    }
}
