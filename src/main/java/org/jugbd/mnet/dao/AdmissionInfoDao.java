package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.AdmissionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author raqibul
 * @since 7/16/14 6:23 PM
 */
@Repository
public interface AdmissionInfoDao extends JpaRepository<AdmissionInfo, Long> {
}
