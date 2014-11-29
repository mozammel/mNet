package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.ChiefComplaintDao;
import org.jugbd.mnet.domain.ChiefComplaint;
import org.jugbd.mnet.domain.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Bazlur Rahman Rokon
 * @date 11/29/2014.
 */
@Service
public class ChiefComplaintServiceImpl implements ChiefComplaintService {

    @Autowired
    private ChiefComplaintDao chiefComplaintDao;

    @Autowired
    private RegisterService registerService;

    @Override
    public ChiefComplaint save(ChiefComplaint chiefComplaint) {

        if (chiefComplaint.getId() == null) {

            Register register = registerService.findOne(chiefComplaint.getRegister().getId());

            chiefComplaint.setRegister(register);
            ChiefComplaint chiefComplaintFromDb = chiefComplaintDao.save(chiefComplaint);

            register.setChiefComplaint(chiefComplaint);
            registerService.save(register);

            return chiefComplaintFromDb;
        } else {
            ChiefComplaint chiefComplaintFromDb = chiefComplaintDao.findOne(chiefComplaint.getId());
            chiefComplaintFromDb.setBreastRelatedComplaint(chiefComplaint.getBreastRelatedComplaint());
            chiefComplaintFromDb.setChildBornWith(chiefComplaint.getChildBornWith());
            chiefComplaintFromDb.setDaysOfBurns(chiefComplaint.getDaysOfBurns());
            chiefComplaintFromDb.setDaysOfInfection(chiefComplaint.getDaysOfInfection());
            chiefComplaintFromDb.setDaysOfTrauma(chiefComplaint.getDaysOfTrauma());
            chiefComplaintFromDb.setDaysOfUlcerOrSwellingFor(chiefComplaint.getDaysOfUlcerOrSwellingFor());
            chiefComplaintFromDb.setHoursOfBurn(chiefComplaint.getHoursOfBurn());
            chiefComplaintFromDb.setHoursOfInfection(chiefComplaint.getHoursOfInfection());
            chiefComplaintFromDb.setHoursOfTrauma(chiefComplaint.getHoursOfTrauma());
            chiefComplaintFromDb.setMonthOfUlcerOrSwellingFor(chiefComplaint.getMonthOfUlcerOrSwellingFor());
            chiefComplaintFromDb.setPresentIllness(chiefComplaint.getPresentIllness());
            chiefComplaintFromDb.setYearsOfUlcerOrSwellingFor(chiefComplaint.getYearsOfUlcerOrSwellingFor());

            return chiefComplaintDao.save(chiefComplaintFromDb);
        }
    }

    @Override
    public ChiefComplaint findOne(Long id) {

        return chiefComplaintDao.findOne(id);
    }
}
