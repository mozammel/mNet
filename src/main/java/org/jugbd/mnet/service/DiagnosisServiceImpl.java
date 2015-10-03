package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.DiagnosisDao;
import org.jugbd.mnet.domain.Diagnosis;
import org.jugbd.mnet.domain.OutdoorRegister;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.domain.enums.RegistrationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Mushfekur Rahman (mushfek0001)
 */
@Service
@Transactional
public class DiagnosisServiceImpl implements DiagnosisService {

    @Autowired
    private DiagnosisDao diagnosisDao;

    @Autowired
    private RegisterService registerService;

    @Override
    public Diagnosis save(Diagnosis diagnosis) {

        if (diagnosis.getId() == null) {
            Register register = registerService.findOne(diagnosis.getRegister().getId());
            diagnosis.setRegister(register);
            Diagnosis savedDiagnosis = diagnosisDao.save(diagnosis);

            register.setDiagnosis(savedDiagnosis);
            registerService.save(register);

            return savedDiagnosis;
        } else {

            return updateDiagnosis(diagnosis);
        }
    }

    @Override
    public Diagnosis findOne(Long id) {

        return diagnosisDao.findOne(id);
    }

    @Override
    public Diagnosis save(Diagnosis diagnosis, RegistrationType registrationType) {

        switch (registrationType) {
            case OUTDOOR:
                if (diagnosis.getId() == null) {
                    OutdoorRegister register = registerService.findOpdRegister(diagnosis.getOutdoorRegister().getId());
                    diagnosis.setOutdoorRegister(register);
                    Diagnosis savedDiagnosis = diagnosisDao.save(diagnosis);

                    register.setDiagnosis(savedDiagnosis);
                    registerService.save(register);

                    return savedDiagnosis;
                } else {

                    return updateDiagnosis(diagnosis);
                }
            case INDOOR:
                if (diagnosis.getId() == null) {
                    Register register = registerService.findOne(diagnosis.getRegister().getId());
                    diagnosis.setRegister(register);
                    Diagnosis savedDiagnosis = diagnosisDao.save(diagnosis);

                    register.setDiagnosis(savedDiagnosis);
                    registerService.save(register);

                    return savedDiagnosis;
                } else {

                    return updateDiagnosis(diagnosis);
                }
        }

        return null;
    }

    private Diagnosis updateDiagnosis(Diagnosis diagnosis) {
        Diagnosis diagnosisFromDb = diagnosisDao.findOne(diagnosis.getId());
        diagnosisFromDb.setIcd10(diagnosis.getIcd10());
        diagnosisFromDb.setAesthetic(diagnosis.getAesthetic());
        diagnosisFromDb.setBurns(diagnosis.getBurns());
        diagnosisFromDb.setCongenitalAnomaly(diagnosis.getCongenitalAnomaly());
        diagnosisFromDb.setNeoplastic(diagnosis.getNeoplastic());
        diagnosisFromDb.setPostInfective(diagnosis.getPostInfective());
        diagnosisFromDb.setTraumatic(diagnosis.getTraumatic());
        diagnosisFromDb.setComment(diagnosis.getComment());

        return diagnosisDao.save(diagnosisFromDb);
    }
}
