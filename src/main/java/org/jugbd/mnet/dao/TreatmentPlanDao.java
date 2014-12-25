package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.TreatmentPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rokonoid on 12/25/14.
 */
@Repository
public interface TreatmentPlanDao extends JpaRepository<TreatmentPlan, Long> {
}
