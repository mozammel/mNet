package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.TreatmentPlan;
import org.springframework.stereotype.Component;

/**
 * Created by rokonoid on 12/25/14.
 */
@Component
public interface TreatmentPlanService {
    TreatmentPlan save(TreatmentPlan treatmentPlan);

    TreatmentPlan findOne(Long id);
}
