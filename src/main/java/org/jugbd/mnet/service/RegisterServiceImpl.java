package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.RegisterDao;
import org.jugbd.mnet.domain.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;

/**
 * Created by Bazlur Rahman Rokon on 8/5/14.
 */
@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterDao registerDao;

    @Override
    public Register findActiveRegisterByPatientId(final Long patientId) {
        return null;
    }

    @Override
    public void save(Register register) {
        registerDao.save(register);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        register.setRegistrationId(register.getId() + "/" + year);
        registerDao.save(register);
    }

    @Override
    public Register findOne(Long registerId) {
        return registerDao.findOne(registerId);
    }
}
