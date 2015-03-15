package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.RegisterDao;
import org.jugbd.mnet.dao.VitalDao;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.domain.Vital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/17/14.
 */
@Repository
@Service
public class VitalServiceImpl implements VitalService {
    @Autowired
    private RegisterDao registerDao;

    @Autowired
    private VitalDao vitalDao;

    @Override
    public Vital saveByRegisterId(Vital vital, Long registerId) {
        Register register = registerDao.findOne(registerId);
        vital.setPatient(register.getPatient());
        vital.setRegister(register);

      return vitalDao.save(vital);
    }

    @Override
    public Vital findOne(Long id) {

        return vitalDao.findOne(id);
    }

    @Override
    public List<Vital> findByRegisterId(Long registerId) {

        return vitalDao.findAll((root, query, cb) -> {
            return cb.equal(root.get("register"), registerId);
        });
    }
}
