package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.Register;
import org.springframework.stereotype.Component;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/14/14.
 */
@Component
public interface RegisterService {
    void save(Register register);

    Register findOne(Long registerId);

    Register findActiveRegisterByPatientId(Long patientId);

    void closeRegister(Long registerId);
}
