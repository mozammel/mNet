package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.ChiefComplaintDao;
import org.jugbd.mnet.domain.ChiefComplaint;
import org.jugbd.mnet.domain.OutdoorRegister;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.domain.enums.RegistrationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Bazlur Rahman Rokon
 * @date 11/29/2014.
 */
@Service
@Transactional
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

            return updateChiefComplaint(chiefComplaint);
        }
    }

    @Override
    public ChiefComplaint findOne(Long id) {

        return chiefComplaintDao.findOne(id);
    }

    @Override
    public ChiefComplaint save(ChiefComplaint chiefComplaint, RegistrationType registrationType) {
        if (registrationType == RegistrationType.INDOOR) {
            if (chiefComplaint.getId() == null) {

                Register register = registerService.findOne(chiefComplaint.getRegister().getId());

                chiefComplaint.setRegister(register);
                ChiefComplaint chiefComplaintFromDb = chiefComplaintDao.save(chiefComplaint);

                register.setChiefComplaint(chiefComplaint);
                registerService.save(register);

                return chiefComplaintFromDb;
            } else {
                return updateChiefComplaint(chiefComplaint);
            }
        } else if (registrationType == RegistrationType.OUTDOOR) {
            if (chiefComplaint.getId() == null) {

                OutdoorRegister register = registerService.findOpdRegister(chiefComplaint.getOutdoorRegister().getId());

                chiefComplaint.setOutdoorRegister(register);
                ChiefComplaint chiefComplaintFromDb = chiefComplaintDao.save(chiefComplaint);

                register.setChiefComplaint(chiefComplaint);
                registerService.save(register);

                return chiefComplaintFromDb;
            } else {
                return updateChiefComplaint(chiefComplaint);
            }
        }

        return null;
    }

    private ChiefComplaint updateChiefComplaint(ChiefComplaint chiefComplaint) {
        ChiefComplaint chiefComplaintFromDb = chiefComplaintDao.findOne(chiefComplaint.getId());
        chiefComplaintFromDb.setBreastRelatedComplaint(chiefComplaint.getBreastRelatedComplaint());
        chiefComplaintFromDb.setChildBornWith(chiefComplaint.getChildBornWith());
        chiefComplaintFromDb.setChildBornWithOther(chiefComplaint.getChildBornWithOther());
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
        chiefComplaintFromDb.setComments(chiefComplaint.getComments());

        return chiefComplaintDao.save(chiefComplaintFromDb);
    }
}
