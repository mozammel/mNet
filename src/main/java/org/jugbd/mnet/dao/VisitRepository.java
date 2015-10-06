package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Bazlur Rahman Rokon
 * @date 10/6/15.
 */
@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
}
