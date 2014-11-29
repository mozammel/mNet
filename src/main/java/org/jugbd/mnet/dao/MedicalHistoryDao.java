package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bazlur Rahman Rokon
 * @date 11/28/2014.
 */
public interface MedicalHistoryDao extends JpaRepository<MedicalHistory, Long> {
}
