package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/14/14.
 */
@Repository
public interface RegisterDao extends JpaRepository<Register, Long> {

    @Query("select o from Register o where o.patient.id=:patientId and o.status='ACTIVE'")
    List<Register> findActiveRegisterByPatientId(@Param("patientId") Long patientId);
}
