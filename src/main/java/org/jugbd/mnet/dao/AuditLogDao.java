package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.AuditLog;
import org.jugbd.mnet.domain.Auditable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author User
 * @date 11/21/2014.
 */
@Repository
@Transactional
public interface AuditLogDao extends JpaRepository<AuditLog, Long> {
}
