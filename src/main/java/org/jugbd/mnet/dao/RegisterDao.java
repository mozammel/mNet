package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Bazlur Rahman Rokon on 8/5/14.
 */
@Repository
public interface RegisterDao extends JpaRepository<Register, Long>, JpaSpecificationExecutor<Register> {
}
