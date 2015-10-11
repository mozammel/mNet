package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.OutdoorRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Bazlur Rahman Rokon
 * @date 10/3/15.
 */

@Repository
public interface OutdoorRegisterRepository extends JpaRepository<OutdoorRegister, Long> {
}
