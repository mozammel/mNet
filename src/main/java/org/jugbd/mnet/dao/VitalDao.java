package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.Vital;
import org.jugbd.mnet.domain.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/17/14.
 */
@Repository
public interface VitalDao extends JpaRepository<Vital, Long>, JpaSpecificationExecutor<Vital> {

    List<Vital> findByStatusAndRegister_Id(Status status, Long id);
}
