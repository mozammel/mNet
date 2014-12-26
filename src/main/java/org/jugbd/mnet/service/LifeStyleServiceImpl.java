package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.LifeStyleDao;
import org.jugbd.mnet.domain.LifeStyle;
import org.jugbd.mnet.domain.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/26/14.
 */

@Service
@Transactional
public class LifeStyleServiceImpl implements LifeStyleService {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private LifeStyleDao lifeStyleDao;

    @Override
    public LifeStyle save(LifeStyle lifeStyle) {

        if (lifeStyle.getId() == null) {
            Register register = registerService.findOne(lifeStyle.getRegister().getId());
            lifeStyle.setRegister(register);

            LifeStyle savedLifeStyle = lifeStyleDao.save(lifeStyle);

            register.setLifeStyle(savedLifeStyle);
            registerService.update(register);

            return savedLifeStyle;
        } else {
            LifeStyle savedLifeStyle = lifeStyleDao.findOne(lifeStyle.getId());
            savedLifeStyle.setEconomicalStatus(lifeStyle.getEconomicalStatus());
            savedLifeStyle.setHabit(lifeStyle.getHabit());
            savedLifeStyle.setOtherHabit(lifeStyle.getOtherHabit());
            savedLifeStyle.setComment(lifeStyle.getComment());

            return lifeStyleDao.save(savedLifeStyle);
        }
    }

    @Override
    public LifeStyle findOne(Long id) {

        return lifeStyleDao.findOne(id);
    }
}
