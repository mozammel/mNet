package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.DiagnosisDao;
import org.jugbd.mnet.domain.Diagnosis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Mushfekur Rahman (mushfek0001)
 * on 7/15/14.
 */
@Service
@Transactional
public class DiagnosisServiceImpl implements DiagnosisService {

    private static final Logger log = LoggerFactory.getLogger(DiagnosisServiceImpl.class);

    @Autowired
    private DiagnosisDao diagnosisDao;

    @Override
    public void saveDiagnosis(Diagnosis diagnosis) {
        log.info("diagnosis={}", diagnosis);

        diagnosisDao.saveDiagnosis(diagnosis);
    }
}
