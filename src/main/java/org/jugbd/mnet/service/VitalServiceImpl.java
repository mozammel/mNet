package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.RegisterDao;
import org.jugbd.mnet.dao.VitalDao;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.domain.Vital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/17/14.
 */
@Repository
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

      return vitalDao.save(vital);
    }

    @Override
    public Vital findOne(Long id) {

        return vitalDao.findOne(id);
    }
}
