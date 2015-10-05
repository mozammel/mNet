package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.ChiefComplaint;
import org.jugbd.mnet.domain.enums.RegistrationType;
import org.springframework.stereotype.Service;

/**
 * @author Bazlur Rahman Rokon
 * @date 11/29/2014.
 */
@Service
public interface ChiefComplaintService {
    ChiefComplaint save(ChiefComplaint chiefComplaint);

    ChiefComplaint findOne(Long id);

    ChiefComplaint save(ChiefComplaint chiefComplaint, RegistrationType registrationType);
}
