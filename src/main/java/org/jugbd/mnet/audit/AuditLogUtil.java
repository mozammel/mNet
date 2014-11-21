package org.jugbd.mnet.audit;

import org.jugbd.mnet.dao.AuditLogDao;
import org.jugbd.mnet.domain.AuditLog;
import org.jugbd.mnet.domain.Auditable;
import org.jugbd.mnet.domain.enums.AuditAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author User
 * @date 11/21/2014.
 */
public class AuditLogUtil {
    private static Logger log = LoggerFactory.getLogger(AuditLogUtil.class);

    public static void logIt(AuditAction action, Auditable entity, AuditLogDao auditLogDao) {
        log.debug(" action ={}, entity.getId()={}, entity.getLogDetail()={}", action, entity.getId(), entity.getLogDetail());

        AuditLog auditLog = new AuditLog();
        auditLog.setAction(action);
        auditLog.setDetail(entity.getLogDetail());
        auditLog.setEntityName(entity.getClass().getName());
        auditLog.setEntityId(entity.getId());

        auditLogDao.save(auditLog);
    }
}
