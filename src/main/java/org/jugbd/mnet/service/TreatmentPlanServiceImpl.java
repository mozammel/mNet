package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.TreatmentPlanDao;
import org.jugbd.mnet.domain.OutdoorRegister;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.domain.TreatmentPlan;
import org.jugbd.mnet.domain.enums.RegistrationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/25/14.
 */
@Service
@Transactional
public class TreatmentPlanServiceImpl implements TreatmentPlanService {

    @Autowired
    private TreatmentPlanDao treatmentPlanDao;

    @Autowired
    private RegisterService registerService;

    @Override
    public TreatmentPlan save(TreatmentPlan treatmentPlan) {
        if (treatmentPlan.getId() == null) {

            Register register = registerService.findOne(treatmentPlan.getRegister().getId());
            treatmentPlan.setRegister(register);
            TreatmentPlan savedTreatmentPlan = treatmentPlanDao.save(treatmentPlan);

            register.setTreatmentPlan(treatmentPlan);
            registerService.update(register);

            return savedTreatmentPlan;
        } else {
            TreatmentPlan treatmentPlanFromDb = treatmentPlanDao.findOne(treatmentPlan.getId());

            treatmentPlanFromDb.setTreatmentPlanType(treatmentPlan.getTreatmentPlanType());
            treatmentPlanFromDb.setOtherTreatmentPlanType(treatmentPlan.getOtherTreatmentPlanType());
            treatmentPlanFromDb.setTypeOfConservativeTreatment(treatmentPlan.getTypeOfConservativeTreatment());
            treatmentPlanFromDb.setStsgOrFtsg(treatmentPlan.getStsgOrFtsg());
            treatmentPlanFromDb.setFlapPedicled(treatmentPlan.getFreeFlap());
            treatmentPlanFromDb.setFreeFlap(treatmentPlan.getFreeFlap());
            treatmentPlanFromDb.setTissueExpansion(treatmentPlan.getTissueExpansion());
            treatmentPlanFromDb.setFasciotomyOrEscharotomy(treatmentPlan.getFasciotomyOrEscharotomy());
            treatmentPlanFromDb.setImplantInsertion(treatmentPlan.getImplantInsertion());
            treatmentPlanFromDb.setRepairReconstructionPart(treatmentPlan.getRepairReconstructionPart());
            treatmentPlanFromDb.setComment(treatmentPlan.getComment());

            return treatmentPlanDao.save(treatmentPlanFromDb);
        }
    }

    @Override
    public TreatmentPlan findOne(Long id) {

        return treatmentPlanDao.findOne(id);
    }

    @Override
    public TreatmentPlan save(TreatmentPlan treatmentPlan, RegistrationType registrationType) {
        switch (registrationType) {
            case OUTDOOR:
                if (treatmentPlan.getId() == null) {
                    OutdoorRegister register = registerService.findOpdRegister(treatmentPlan.getOutdoorRegister().getId());
                    treatmentPlan.setOutdoorRegister(register);
                    TreatmentPlan savedTreatmentPlan = treatmentPlanDao.save(treatmentPlan);

                    register.setTreatmentPlan(savedTreatmentPlan);
                    registerService.update(register);

                    return register.getTreatmentPlan();
                } else {

                    return updateTreatmentPlan(treatmentPlan);
                }
            case INDOOR:
                if (treatmentPlan.getId() == null) {
                    Register register = registerService.findOne(treatmentPlan.getRegister().getId());
                    treatmentPlan.setRegister(register);
                    TreatmentPlan savedTreatmentPlan = treatmentPlanDao.save(treatmentPlan);

                    register.setTreatmentPlan(treatmentPlan);
                    registerService.update(register);

                    return savedTreatmentPlan;
                } else {

                    return updateTreatmentPlan(treatmentPlan);
                }
        }

        return null;
    }

    private TreatmentPlan updateTreatmentPlan(TreatmentPlan treatmentPlan) {
        TreatmentPlan treatmentPlanFromDb = treatmentPlanDao.findOne(treatmentPlan.getId());

        treatmentPlanFromDb.setTreatmentPlanType(treatmentPlan.getTreatmentPlanType());
        treatmentPlanFromDb.setOtherTreatmentPlanType(treatmentPlan.getOtherTreatmentPlanType());
        treatmentPlanFromDb.setTypeOfConservativeTreatment(treatmentPlan.getTypeOfConservativeTreatment());
        treatmentPlanFromDb.setStsgOrFtsg(treatmentPlan.getStsgOrFtsg());
        treatmentPlanFromDb.setFlapPedicled(treatmentPlan.getFreeFlap());
        treatmentPlanFromDb.setFreeFlap(treatmentPlan.getFreeFlap());
        treatmentPlanFromDb.setTissueExpansion(treatmentPlan.getTissueExpansion());
        treatmentPlanFromDb.setFasciotomyOrEscharotomy(treatmentPlan.getFasciotomyOrEscharotomy());
        treatmentPlanFromDb.setImplantInsertion(treatmentPlan.getImplantInsertion());
        treatmentPlanFromDb.setRepairReconstructionPart(treatmentPlan.getRepairReconstructionPart());
        treatmentPlanFromDb.setComment(treatmentPlan.getComment());

        return treatmentPlanDao.save(treatmentPlanFromDb);
    }
}
