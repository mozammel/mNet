package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.AdmissionInfoDao;
import org.jugbd.mnet.domain.AdmissionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author raqibul
 * @since 7/16/14 6:31 PM
 */
@Service
@Transactional
public class AdmissionInfoServiceImpl implements AdmissionInfoService {

    @Autowired
    private AdmissionInfoDao admissionInfoDao;

    @Override
    public void save(AdmissionInfo admissionInfo) {
        admissionInfoDao.save(admissionInfo);
    }

    @Override
    public AdmissionInfo findOne(Long id) {
        return admissionInfoDao.findOne(id);
    }
}
