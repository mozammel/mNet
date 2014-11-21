package org.jugbd.mnet.domain;

import org.jugbd.mnet.domain.enums.AuditAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Bazlur Rahman Rokon
 * @date 11/21/2014.
 */
@Entity
public class AuditLog extends PersistentObject{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long auditLogId;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private AuditAction action;

    @Column(columnDefinition = "TEXT")
    private String detail;
    private Long entityId;
    private String entityName;

    public Long getAuditLogId() {
        return auditLogId;
    }

    public void setAuditLogId(Long auditLogId) {
        this.auditLogId = auditLogId;
    }

    public AuditAction getAction() {
        return action;
    }

    public void setAction(AuditAction action) {
        this.action = action;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public long getEntityId() {
        return entityId;
    }

    public void setEntityId(long entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
}
