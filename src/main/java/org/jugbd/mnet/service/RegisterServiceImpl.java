package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.OutdoorRegisterRepository;
import org.jugbd.mnet.dao.PatientDao;
import org.jugbd.mnet.dao.RegisterDao;
import org.jugbd.mnet.dao.VitalDao;
import org.jugbd.mnet.domain.*;
import org.jugbd.mnet.domain.enums.RegistrationType;
import org.jugbd.mnet.domain.enums.Status;
import org.jugbd.mnet.utils.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/14/14.
 */
@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {

    private static final Logger log = LoggerFactory.getLogger(RegisterService.class);

    @Autowired
    private RegisterDao registerDao;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private OutdoorRegisterRepository outdoorRegisterRepository;

    @Autowired
    private VitalDao vitalDao;

    @Override
    public Register save(Register register) {
        if (register.getId() != null) {
            Register registerFromDb = registerDao.findOne(register.getId());

            PatientContact patientContact = registerFromDb.getPatientContact();
            patientContact.setContactPerson(register.getPatientContact().getContactPerson());
            patientContact.setEmergencyContactNumber(register.getPatientContact().getEmergencyContactNumber());
            patientContact.setRelationship(register.getPatientContact().getRelationship());
            patientContact.setComments(register.getPatientContact().getComments());

            registerFromDb.setRegistrationId(register.getRegistrationId());
            registerFromDb.setWard(register.getWard());
            registerFromDb.setWardOther(register.getWardOther());
            registerFromDb.setBedNumber(register.getBedNumber());
            registerFromDb.setUnit(register.getUnit());
            registerFromDb.setAdmissionDate(register.getAdmissionDate());

            return registerDao.save(registerFromDb);
        } else {
            register.setPatient(patientDao.findOne(register.getPatient().getId()));
            register.setStartDatetime(new Date());
            register.setStatus(Status.ACTIVE);

            return registerDao.save(register);
        }
    }

    @Override
    public Register findOne(Long registerId) {

        Register register = registerDao.findOne(registerId);
        initializeRegister(register);

        return register;
    }

    @Override
    public Register findActiveRegisterByPatientId(Long patientId) {

        return Optional.ofNullable(registerDao.findActiveRegisterByPatientId(patientId))
                .map(registers -> registers.stream()
                        .findFirst()
                        .map(this::initializeRegister)
                        .orElse(null))
                .orElse(null);
    }

    @Override
    public List<Register> findAllRegisterByPatientId(Long patientId) {

        return registerDao.findAllRegisterByPatientId(patientId);
    }

    private Register initializeRegister(Register register) {
        //log.info("initializeRegister() ={}", register);
        // Ref: http://stackoverflow.com/questions/19928568/hibernate-best-practice-to-pull-all-lazy-collections
        register.getVitals().size();
        register.getOperationalDetails().size();
        register.getInvestigation().size();

        return register;
    }

    @Override
    public void closeRegister(Long registerId) {
        Register register = registerDao.findOne(registerId);
        register.setStatus(Status.CLOSED);
        register.setStopDatetime(new Date());
        registerDao.save(register);
    }

    @Override
    public void update(Register register) {

        registerDao.save(register);
    }

    @Override
    public void addVital(Vital vital, Long registerId) {

    }

    @Override
    public OutdoorRegister save(OutdoorRegister register) {
        if (register.getId() != null) {
            OutdoorRegister registerFromDb = outdoorRegisterRepository.findOne(register.getId());

            PatientContact patientContact = registerFromDb.getPatientContact();
            patientContact.setContactPerson(register.getPatientContact().getContactPerson());
            patientContact.setEmergencyContactNumber(register.getPatientContact().getEmergencyContactNumber());
            patientContact.setRelationship(register.getPatientContact().getRelationship());
            patientContact.setComments(register.getPatientContact().getComments());
            registerFromDb.setRegistrationId(register.getRegistrationId());

            return outdoorRegisterRepository.save(registerFromDb);
        } else {

            register.setPatient(patientDao.findOne(register.getPatient().getId()));
            register.setStartDatetime(new Date());
            register.setStatus(Status.ACTIVE);

            return outdoorRegisterRepository.save(register);
        }
    }

    @Override
    public OutdoorRegister findOpdRegister(Long id) {

        return outdoorRegisterRepository.findOne(id);
    }

    @Override
    public Diagnosis findDiagnosis(Long registerId, RegistrationType registrationType) {
        if (registrationType == RegistrationType.OUTDOOR) {
            OutdoorRegister outdoorRegister = outdoorRegisterRepository.findOne(registerId);

            return outdoorRegister.getDiagnosis();
        } else if (registrationType == RegistrationType.INDOOR) {
            Register indoorRegister = registerDao.findOne(registerId);

            return indoorRegister.getDiagnosis();
        }

        return null;
    }

    @Override
    public Object findRegister(Long registerId, RegistrationType registrationType) {
        if (registrationType == RegistrationType.OUTDOOR) {
            return outdoorRegisterRepository.findOne(registerId);

        } else if (registrationType == RegistrationType.INDOOR) {

            return registerDao.findOne(registerId);
        }

        return null;
    }

    @Override
    public Either<Register, OutdoorRegister> findRegisterEither(Long registerId, RegistrationType registrationType) {

        return registrationType == RegistrationType.OUTDOOR ?
                Either.right(outdoorRegisterRepository.findOne(registerId)) : Either.left(registerDao.findOne(registerId));
    }

    @Override
    public TreatmentPlan findTreatmentPlan(Long registerId, RegistrationType registrationType) {
        if (registrationType == RegistrationType.OUTDOOR) {
            OutdoorRegister outdoorRegister = outdoorRegisterRepository.findOne(registerId);

            return outdoorRegister.getTreatmentPlan();
        } else if (registrationType == RegistrationType.INDOOR) {
            Register indoorRegister = registerDao.findOne(registerId);

            return indoorRegister.getTreatmentPlan();
        }

        return null;
    }

    @Override
    public void update(OutdoorRegister register) {

        outdoorRegisterRepository.save(register);
    }

    @Override
    public Examination findExamination(Long registerId, RegistrationType registrationType) {

        if (registrationType == RegistrationType.OUTDOOR) {
            OutdoorRegister outdoorRegister = outdoorRegisterRepository.findOne(registerId);

            return outdoorRegister.getExamination();
        } else if (registrationType == RegistrationType.INDOOR) {
            Register indoorRegister = registerDao.findOne(registerId);

            return indoorRegister.getExamination();
        }

        return null;
    }

    @Override
    public ChiefComplaint findChiefcomplaints(Long registerId, RegistrationType registrationType) {

        if (registrationType == RegistrationType.OUTDOOR) {
            OutdoorRegister outdoorRegister = outdoorRegisterRepository.findOne(registerId);

            return outdoorRegister.getChiefComplaint();
        } else if (registrationType == RegistrationType.INDOOR) {
            Register indoorRegister = registerDao.findOne(registerId);

            return indoorRegister.getChiefComplaint();
        }

        return null;
    }

    @Override
    public Vital getLastVital(Long registerId, RegistrationType registrationType) {
        log.info("getLastVital() registerId:{}, registrationType : {}", registerId, registrationType);

        return findRegisterEither(registerId, registrationType)
                .fold(register -> getVital(register.getVitals()),
                        outdoorRegister -> getVital(outdoorRegister.getVitals()));
    }

    private Vital getVital(Set<Vital> vitals) {

        return vitals.stream()
                .filter(vital -> vital.getStatus() == Status.ACTIVE)
                .sorted((e1, e2) -> e2.getCreatedDate().compareTo(e1.getCreatedDate()))
                .findFirst()
                .orElse(null);
    }
}
