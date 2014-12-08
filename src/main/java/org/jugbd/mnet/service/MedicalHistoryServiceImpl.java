package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.MedicalHistoryDao;
import org.jugbd.mnet.domain.MedicalHistory;
import org.jugbd.mnet.domain.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Bazlur Rahman Rokon
 * @date 11/28/2014.
 */
@Service
@Transactional
public class MedicalHistoryServiceImpl implements MedicalHistoryService {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private MedicalHistoryDao medicalHistoryDao;

    @Override
    public MedicalHistory save(MedicalHistory medicalHistory) {

        if (medicalHistory.getId() == null) {
            Register register = registerService.findOne(medicalHistory.getRegister().getId());
            register.setMedicalHistory(medicalHistory);

            registerService.save(register);
            medicalHistory.setRegister(register);

            return medicalHistoryDao.save(medicalHistory);
        } else {
            MedicalHistory medicalHistoryFromDb = medicalHistoryDao.findOne(medicalHistory.getId());
            medicalHistoryFromDb.setDays(medicalHistory.getDays());
            medicalHistoryFromDb.setPeriod(medicalHistory.getPeriod());
            medicalHistoryFromDb.setDrugHistory(medicalHistory.getDrugHistory());
            medicalHistoryFromDb.setFamilyHistory(medicalHistory.getFamilyHistory());
            medicalHistoryFromDb.setMenstrualCycle(medicalHistory.getMenstrualCycle());
            medicalHistoryFromDb.setPastMedicalHistory(medicalHistory.getPastMedicalHistory());
            medicalHistoryFromDb.setPastSurgicalHistory(medicalHistory.getPastSurgicalHistory());
            medicalHistoryFromDb.setPresentIllness(medicalHistory.getPresentIllness());
            medicalHistoryFromDb.setSimilarDiseasesInFamily(medicalHistory.getSimilarDiseasesInFamily());

            return medicalHistoryDao.save(medicalHistoryFromDb);
        }
    }

    @Override
    public MedicalHistory findOne(Long id) {

        return medicalHistoryDao.findOne(id);
    }
}
