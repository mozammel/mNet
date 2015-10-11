package org.jugbd.mnet.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.jugbd.mnet.domain.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Bazlur Rahman Rokon on 8/8/14.
 */
@Entity
public class Visit extends PersistentObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @Temporal(TemporalType.TIMESTAMP)
    private Date visitTime;

    @NotEmpty(message = "Visit note can not be empty")
    @Size(max = 3000)
    @Column(length = 3000)
    private String comment;

    @NotEmpty(message = "Please put the name doctor's name")
    @Size(max = 120)
    private String doctorsName;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 10)
    private Status status;

    @ManyToOne
    private Register register;

    @ManyToOne
    private OutdoorRegister outdoorRegister;

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

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDoctorsName() {
        return doctorsName;
    }

    public Visit setDoctorsName(String doctorsName) {
        this.doctorsName = doctorsName;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Visit setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Register getRegister() {
        return register;
    }

    public Visit setRegister(Register register) {
        this.register = register;
        return this;
    }

    public OutdoorRegister getOutdoorRegister() {
        return outdoorRegister;
    }

    public Visit setOutdoorRegister(OutdoorRegister outdoorRegister) {
        this.outdoorRegister = outdoorRegister;
        return this;
    }
}
