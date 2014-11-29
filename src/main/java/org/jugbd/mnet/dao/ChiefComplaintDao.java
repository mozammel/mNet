package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.ChiefComplaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Bazlur Rahman Rokon
 * @date 11/29/2014.
 */
@Repository
public interface ChiefComplaintDao extends JpaRepository<ChiefComplaint, Long> {
}
