package org.jugbd.mnet.service;

import org.hibernate.Hibernate;
import org.jugbd.mnet.dao.PatientDao;
import org.jugbd.mnet.dao.RegisterDao;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.domain.enums.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;

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

    @Override
    public void save(Register register) {
        register.setPatient(patientDao.findOne(register.getPatient().getId()));
        register.setStartDatetime(new Date());
        register.setStatus(Status.ACTIVE);
        registerDao.save(register);

        int year = Calendar.getInstance().get(Calendar.YEAR);
        register.setRegistrationId(register.getId() + "/" + year);

        registerDao.save(register);
    }

    @Override
    public Register findOne(Long registerId) {

        return registerDao.findOne(registerId);
    }

    @Override
    public Register findActiveRegisterByPatientId(Long patientId) {

        Register register = registerDao.findActiveRegisterByPatientId(patientId);
        if (register != null) {

            register.getDiagnoses().size(); // Ref: http://stackoverflow.com/questions/19928568/hibernate-best-practice-to-pull-all-lazy-collections
            register.getVitals().size();
        }

        return register;
    }

    @Override
    public void closeRegister(Long registerId) {
        Register register = registerDao.findOne(registerId);
        register.setStatus(Status.CLOSED);
        registerDao.save(register);
    }
}
