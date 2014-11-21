package org.jugbd.mnet.audit;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.jugbd.mnet.dao.AuditLogDao;
import org.jugbd.mnet.domain.Auditable;
import org.jugbd.mnet.domain.enums.AuditAction;
import org.jugbd.mnet.web.ApplicationContextProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Bazlur Rahman Rokon
 * @date 11/21/2014.
 */
@Component
public class AuditLogInterceptor extends EmptyInterceptor {
    private static final Logger log = LoggerFactory.getLogger(AuditLogInterceptor.class);

    private Set inserts = new HashSet();
    private Set updates = new HashSet();
    private Set deletes = new HashSet();

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        log.debug("onSave()");

        if (entity instanceof Auditable) {
            inserts.add(entity);
        }

        return false;
    }

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        log.debug("onFlushDirty()");

        if (entity instanceof Auditable) {
            updates.add(entity);
        }

        return false;
    }

    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        log.debug("onDelete()");

        if (entity instanceof Auditable) {
            deletes.add(entity);
        }
    }

    @Override
    public void preFlush(Iterator entities) {
        log.debug("preFlush()");
    }

    @Override
    public void postFlush(Iterator entities) {
        log.debug("postFlush()");

        AuditLogDao auditLogDao = (AuditLogDao) ApplicationContextProvider.getApplicationContext().getBean("auditLogDao");

        try {

            for (Iterator it = inserts.iterator(); it.hasNext(); ) {
                Auditable entity = (Auditable) it.next();
                AuditLogUtil.logIt(AuditAction.CREATED, entity, auditLogDao);
            }

            for (Iterator it = updates.iterator(); it.hasNext(); ) {
                Auditable entity = (Auditable) it.next();

                AuditLogUtil.logIt(AuditAction.UPDATED, entity, auditLogDao);
            }

            for (Iterator it = deletes.iterator(); it.hasNext(); ) {
                Auditable entity = (Auditable) it.next();

                AuditLogUtil.logIt(AuditAction.DELETED, entity, auditLogDao);
            }

        } finally {
            inserts.clear();
            updates.clear();
            deletes.clear();
        }
    }
}

