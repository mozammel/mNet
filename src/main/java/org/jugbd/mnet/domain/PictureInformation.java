package org.jugbd.mnet.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/27/14.
 */
@Entity
public class PictureInformation extends PersistentObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "day_one_attachment_id")
    private Set<Attachment> dayOneAttachments = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pre_operative_attachment_id")
    private Set<Attachment> preOperativeAttachments = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pre_operation_attachment_id")
    private Set<Attachment> preOperationAttachments = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "post_operative_attachment_id")
    private Set<Attachment> postOperativeAttachments = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "on_discharge_attachment_id")
    private Set<Attachment> onDischargeAttachments = new HashSet<>();

    @OneToOne(mappedBy = "pictureInformation")
    private Register register;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Set<Attachment> getDayOneAttachments() {
        return dayOneAttachments;
    }

    public void setDayOneAttachments(Set<Attachment> dayOneAttachments) {
        this.dayOneAttachments = dayOneAttachments;
    }

    public Set<Attachment> getPreOperativeAttachments() {
        return preOperativeAttachments;
    }

    public void setPreOperativeAttachments(Set<Attachment> preOperativeAttachments) {
        this.preOperativeAttachments = preOperativeAttachments;
    }

    public Set<Attachment> getPreOperationAttachments() {
        return preOperationAttachments;
    }

    public void setPreOperationAttachments(Set<Attachment> preOperationAttachments) {
        this.preOperationAttachments = preOperationAttachments;
    }

    public Set<Attachment> getPostOperativeAttachments() {
        return postOperativeAttachments;
    }

    public void setPostOperativeAttachments(Set<Attachment> postOperativeAttachments) {
        this.postOperativeAttachments = postOperativeAttachments;
    }

    public Set<Attachment> getOnDischargeAttachments() {
        return onDischargeAttachments;
    }

    public void setOnDischargeAttachments(Set<Attachment> onDischargeAttachments) {
        this.onDischargeAttachments = onDischargeAttachments;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }
}
