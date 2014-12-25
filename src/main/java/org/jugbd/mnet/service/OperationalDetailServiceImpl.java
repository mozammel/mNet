package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.OperationalDetailDao;
import org.jugbd.mnet.domain.OperationalDetail;
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
public class OperationalDetailServiceImpl implements OperationalDetailService {

    @Autowired
    private OperationalDetailDao operationalDetailDao;

    @Autowired
    private RegisterService registerService;

    @Override
    public OperationalDetail save(OperationalDetail operationalDetail) {
        if (operationalDetail.getId() == null) {
            Register register = registerService.findOne(operationalDetail.getId());

            operationalDetail.setRegister(register);

            return operationalDetailDao.save(operationalDetail);
        } else {
            OperationalDetail operationalDetailSaved = operationalDetailDao.findOne(operationalDetail.getId());
            operationalDetailSaved.setDateTime(operationalDetail.getDateTime());
            operationalDetailSaved.setAnaesthesia(operationalDetail.getAnaesthesia());
            operationalDetailSaved.setNameOfOperation(operationalDetail.getNameOfOperation());
            operationalDetailSaved.setIndication(operationalDetail.getIndication());
            operationalDetailSaved.setNameOfSurgeon(operationalDetail.getNameOfSurgeon());
            operationalDetailSaved.setNameOfAnaesthetist(operationalDetail.getNameOfAnaesthetist());
            operationalDetailSaved.setFindings(operationalDetail.getFindings());
            operationalDetailSaved.setIncision(operationalDetail.getIncision());
            operationalDetailSaved.setDonorSite(operationalDetail.getDonorSite());
            operationalDetailSaved.setPlasty(operationalDetail.getPlasty());
            operationalDetailSaved.setRecipientSite(operationalDetail.getRecipientSite());
            operationalDetailSaved.setBloodTransfusion(operationalDetail.getBloodTransfusion());
            operationalDetailSaved.setDrain(operationalDetail.getDrain());

            return operationalDetailDao.save(operationalDetailSaved);
        }
    }

    @Override
    public OperationalDetail findOne(Long id) {

        return operationalDetailDao.findOne(id);
    }
}
