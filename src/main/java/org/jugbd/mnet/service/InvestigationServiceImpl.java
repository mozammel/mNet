package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.InvestigationDao;
import org.jugbd.mnet.domain.Investigation;
import org.jugbd.mnet.domain.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/27/14.
 */
@Transactional
@Service
public class InvestigationServiceImpl implements InvestigationService {

    @Autowired
    private InvestigationDao investigationDao;

    @Autowired
    private RegisterService registerService;

    @Override
    public Investigation save(Investigation investigation) {

        if (investigation.getId() == null) {
            Register register = registerService.findOne(investigation.getRegister().getId());

            investigation.setRegister(register);
            Investigation savedInvestigation = investigationDao.save(investigation);

            register.setInvestigation(savedInvestigation);

            return savedInvestigation;
        } else {

            Investigation savedInvestigation = investigationDao.findOne(investigation.getId());
            savedInvestigation.setBloodCbc(investigation.getBloodCbc());
            savedInvestigation.setBloodCs(investigation.getBloodCs());
            savedInvestigation.setRbs(investigation.getRbs());
            savedInvestigation.setWoundCs(investigation.getWoundCs());
            savedInvestigation.setSerumCreatinine(investigation.getSerumCreatinine());
            savedInvestigation.setSerumAlbumin(investigation.getSerumAlbumin());
            savedInvestigation.setsTotalProtein(investigation.getsTotalProtein());
            savedInvestigation.setAlbuminGlobulinRatio(investigation.getAlbuminGlobulinRatio());
            savedInvestigation.setElectrolyte(investigation.getElectrolyte());
            savedInvestigation.setSgpt(investigation.getSgpt());
            savedInvestigation.setAlphos(investigation.getAlphos());
            savedInvestigation.setAptt(investigation.getAptt());
            savedInvestigation.setPt(investigation.getPt());
            savedInvestigation.setFdp(investigation.getFdp());
            savedInvestigation.setdDimer(investigation.getdDimer());
            savedInvestigation.setcReactiveProtein(investigation.getcReactiveProtein());
            savedInvestigation.setxRayUsg(investigation.getxRayUsg());
            savedInvestigation.setDuplexScanDopplerStudy(investigation.getDuplexScanDopplerStudy());
            savedInvestigation.setFnacHistopathology(investigation.getFnacHistopathology());

            return savedInvestigation;
        }
    }

    @Override
    public Investigation findOne(Long id) {

        return investigationDao.findOne(id);
    }
}
