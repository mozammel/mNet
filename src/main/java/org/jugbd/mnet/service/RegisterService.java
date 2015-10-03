package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.Diagnosis;
import org.jugbd.mnet.domain.OutdoorRegister;
import org.jugbd.mnet.domain.Register;
import org.jugbd.mnet.domain.Vital;
import org.jugbd.mnet.domain.enums.RegistrationType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/14/14.
 */
@Component
public interface RegisterService {
    Register save(Register register);

    Register findOne(Long registerId);

    Register findActiveRegisterByPatientId(Long patientId);

    List<Register> findAllRegisterByPatientId(Long patientId);

    void closeRegister(Long registerId);

    void update(Register register);

    void addVital(Vital vital, Long registerId);

    OutdoorRegister save(OutdoorRegister register);

    OutdoorRegister findOpdRegister(Long id);

    Diagnosis findDiagnosis(Long registerId, RegistrationType registrationType);

    Object findRegister(Long registerId, RegistrationType registrationType);
}
