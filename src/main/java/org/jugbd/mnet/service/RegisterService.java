package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.Patient;
import org.jugbd.mnet.domain.Register;
import org.springframework.stereotype.Component;

/**
 * Created by Bazlur Rahman Rokon on 8/5/14.
 */
@Component
public interface RegisterService {
    Register findActiveRegisterByPatientId(Long patientId);

    void save(Register register);

    Register findOne(Long registerId);

}
