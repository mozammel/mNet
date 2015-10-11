package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.VisitRepository;
import org.jugbd.mnet.domain.Visit;
import org.jugbd.mnet.domain.enums.RegistrationType;
import org.jugbd.mnet.domain.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Bazlur Rahman Rokon
 * @date 10/6/15.
 */

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private RegisterService registerService;

    public Visit save(Visit visit, Long registerId, RegistrationType registrationType) {

        Visit folded = registerService.findRegisterEither(registerId, registrationType)
                .fold(visit::setRegister, visit::setOutdoorRegister);

        folded.setStatus(Status.ACTIVE);
        folded.setVisitTime(new Date());

        return visitRepository.save(folded);
    }

    public Long delete(Long id, RegistrationType registrationType) {
        Visit visit = visitRepository.findOne(id);
        visit.setStatus(Status.DELETED);
        Visit savedVital = visitRepository.save(visit);

        return registrationType == RegistrationType.OUTDOOR ?
                savedVital.getOutdoorRegister().getId() : savedVital.getRegister().getId();
    }
}
