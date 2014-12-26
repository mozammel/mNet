package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.ComplicationManagementDao;
import org.jugbd.mnet.domain.ComplicationManagement;
import org.jugbd.mnet.domain.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/26/14.
 */
@Service
@Transactional
public class ComplicationManagementServiceImpl implements ComplicationManagementService {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private ComplicationManagementDao complicationManagementDao;

    @Override
    public ComplicationManagement save(ComplicationManagement complicationManagement) {
        if (complicationManagement.getId() == null) {
            Register register = registerService.findOne(complicationManagement.getRegister().getId());
            complicationManagement.setRegister(register);

            ComplicationManagement savedComplicationManagement = complicationManagementDao.save(complicationManagement);
            register.setComplicationManagement(savedComplicationManagement);

            registerService.save(register);

            return savedComplicationManagement;
        } else {
            ComplicationManagement complicationManagementFromDb = complicationManagementDao.findOne(complicationManagement.getId());

            complicationManagementFromDb.setPostOperativeComplication(complicationManagement.getPostOperativeComplication());
            complicationManagementFromDb.setManagementOfComplication(complicationManagement.getManagementOfComplication());
            complicationManagementFromDb.setOutcome(complicationManagement.getOutcome());
            complicationManagementFromDb.setComment(complicationManagement.getComment());
            complicationManagementFromDb.setHospitalStays(complicationManagement.getHospitalStays());
            complicationManagementFromDb.setCaseSummery(complicationManagement.getCaseSummery());

            return complicationManagementDao.save(complicationManagementFromDb);
        }
    }

    @Override
    public ComplicationManagement findOne(Long id) {
        return complicationManagementDao.findOne(id);
    }
}
