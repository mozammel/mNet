package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.TreatmentPlan;
import org.jugbd.mnet.domain.enums.RegistrationType;
import org.springframework.stereotype.Component;

/**
 * Created by rokonoid on 12/25/14.
 */
@Component
public interface TreatmentPlanService {
    TreatmentPlan save(TreatmentPlan treatmentPlan);

    TreatmentPlan findOne(Long id);

    TreatmentPlan save(TreatmentPlan treatmentPlan, RegistrationType registrationType);
}
