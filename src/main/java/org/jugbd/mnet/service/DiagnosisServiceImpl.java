package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.DiagnosisDao;
import org.jugbd.mnet.dao.RegisterDao;
import org.jugbd.mnet.domain.Diagnosis;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.domain.enums.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Mushfekur Rahman (mushfek0001)
 */
@Service
@Transactional
public class DiagnosisServiceImpl implements DiagnosisService {

    private static final Logger log = LoggerFactory.getLogger(DiagnosisServiceImpl.class);

    @Autowired
    private DiagnosisDao diagnosisDao;

    @Autowired
    private RegisterDao registerDao;

    @Override
    public void saveDiagnosis(Diagnosis diagnosis) {

        List<Diagnosis> activeDiagnosis = diagnosisDao.findActiveDiagnosisByRegisterId(diagnosis.getRegister().getId());
        Iterator<Diagnosis> iterator = activeDiagnosis.iterator();

        while (iterator.hasNext()) {
            Diagnosis d = iterator.next();
            d.setStatus(Status.CLOSED);
            diagnosisDao.save(d);
        }

        diagnosis.setEntryDate(new Date());
        diagnosis.setStatus(Status.ACTIVE);
        Register register = registerDao.getOne(diagnosis.getRegister().getId());
        diagnosis.setRegister(register);
        diagnosisDao.save(diagnosis);
    }

    @Override
    public Diagnosis getDiagnosis(Long diagnosisId) {

        return diagnosisDao.findOne(diagnosisId);
    }

    @Override
    public List<Diagnosis> getDiagnosisList(Long patientId, Long admissionId) {
        //return diagnosisDao.getDiagnosisList(patientId, admissionId);
        return null;
    }

    @Override
    public void updateDiagnosis(Diagnosis diagnosis) {
        Diagnosis savedDiagnosis = diagnosisDao.findOne(diagnosis.getId());
        savedDiagnosis.setChiefComplain(diagnosis.getChiefComplain());
        savedDiagnosis.setPresentIllness(diagnosis.getPresentIllness());
        savedDiagnosis.setAssociatedSymptoms(diagnosis.getAssociatedSymptoms());
        savedDiagnosis.setPhysicalExamination(diagnosis.getPhysicalExamination());
        savedDiagnosis.setSystemicExamination(diagnosis.getSystemicExamination());
        savedDiagnosis.setPlan(diagnosis.getPlan());

        diagnosisDao.save(savedDiagnosis);
    }
}
