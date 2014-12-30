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
            savedInvestigation.setDateRbs(investigation.getDateRbs());
            savedInvestigation.setWoundCs(investigation.getWoundCs());
            savedInvestigation.setSerumCreatinine(investigation.getSerumCreatinine());
            savedInvestigation.setDateSerumCreatinine(investigation.getDateSerumCreatinine());
            savedInvestigation.setSerumAlbumin(investigation.getSerumAlbumin());
            savedInvestigation.setDateSerumAlbumin(investigation.getDateSerumAlbumin());
            savedInvestigation.setsTotalProtein(investigation.getsTotalProtein());
            savedInvestigation.setDateSTotalProtein(investigation.getDateSTotalProtein());
            savedInvestigation.setAlbuminGlobulinRatio(investigation.getAlbuminGlobulinRatio());
            savedInvestigation.setDateAlbuminGlobulinRatio(investigation.getDateAlbuminGlobulinRatio());
            savedInvestigation.setElectrolyte(investigation.getElectrolyte());
            savedInvestigation.setSgpt(investigation.getSgpt());
            savedInvestigation.setDateSgpt(investigation.getDateSgpt());
            savedInvestigation.setAlphos(investigation.getAlphos());
            savedInvestigation.setDateAlphos(investigation.getDateAlphos());
            savedInvestigation.setAptt(investigation.getAptt());
            savedInvestigation.setDateAptt(investigation.getDateAptt());
            savedInvestigation.setPt(investigation.getPt());
            savedInvestigation.setFdp(investigation.getFdp());
            savedInvestigation.setDateFdp(investigation.getDateFdp());
            savedInvestigation.setdDimer(investigation.getdDimer());
            savedInvestigation.setDateDDimer(investigation.getDateDDimer());
            savedInvestigation.setcReactiveProtein(investigation.getcReactiveProtein());
            savedInvestigation.setDateCReactiveProtein(investigation.getDateCReactiveProtein());
            savedInvestigation.setxRayUsg(investigation.getxRayUsg());
            savedInvestigation.setDateOfXRayUsg(investigation.getDateOfXRayUsg());
            savedInvestigation.setMriMraCtEchoEcg(investigation.getMriMraCtEchoEcg());
            savedInvestigation.setDateOfMriMraCtEchoEcg(investigation.getDateOfMriMraCtEchoEcg());
            savedInvestigation.setDuplexScanDopplerStudy(investigation.getDuplexScanDopplerStudy());
            savedInvestigation.setDateOfDuplexScanDopplerStudy(investigation.getDateOfDuplexScanDopplerStudy());
            savedInvestigation.setFnacHistopathology(investigation.getFnacHistopathology());
            savedInvestigation.setDateOfFnacHistopathology(investigation.getDateOfFnacHistopathology());
            savedInvestigation.setOtherInvestigation(investigation.getOtherInvestigation());

            return investigationDao.save(savedInvestigation);
        }
    }

    @Override
    public Investigation findOne(Long id) {

        return investigationDao.findOne(id);
    }
}
