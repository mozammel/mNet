package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.Investigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/27/14.
 */
@Repository
public interface InvestigationDao extends JpaRepository<Investigation, Long> {
}
