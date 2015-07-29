package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.RegisterDao;
import org.jugbd.mnet.dao.VitalDao;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.domain.Vital;
import org.jugbd.mnet.domain.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/17/14.
 */
@Transactional
@Service
public class VitalServiceImpl implements VitalService {
    @Autowired
    private RegisterDao registerDao;

    @Autowired
    private VitalDao vitalDao;

    @Override
    public Vital saveByRegisterId(Vital vital, Long registerId) {
        Register register = registerDao.findOne(registerId);
        vital.setPatient(register.getPatient());
        vital.setRegister(register);
        vital.setStatus(Status.ACTIVE);

        return vitalDao.save(vital);
    }

    @Override
    public Vital findOne(Long id) {

        return vitalDao.findOne(id);
    }

    @Override
    public List<Vital> findByRegisterId(Long registerId) {

        return vitalDao.findByStatusAndRegister_Id(Status.ACTIVE, registerId);
    }

    @Override
    public Long delete(Long id) {
        Vital vital = vitalDao.findOne(id);
        vital.setStatus(Status.DELETED);
        Vital savedVital = vitalDao.save(vital);

        return savedVital.getRegister().getId();
    }
}
