package org.jugbd.mnet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.jugbd.mnet.domain.enums.Outcome;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/26/14.
 */
@Entity
public class ComplicationManagement extends PersistentObject implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @NotEmpty
    @Size(max = 2000)
    private String postOperativeComplication;

    @Size(max = 2000)
    private String managementOfComplication;

    @NotNull
    @Column(length = 12)
    @Enumerated(EnumType.STRING)
    private Outcome outcome;

    @Size(max = 100)
    private String comment; // if others

    @NotNull
    private Integer hospitalStays;

    @Size(max = 2000)
    private String caseSummery;

    @JsonIgnore
    @OneToOne(mappedBy = "complicationManagement")
    private Register register;

    @Override
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

    public String getPostOperativeComplication() {
        return postOperativeComplication;
    }

    public void setPostOperativeComplication(String postOperativeComplication) {
        this.postOperativeComplication = postOperativeComplication;
    }

    public String getManagementOfComplication() {
        return managementOfComplication;
    }

    public void setManagementOfComplication(String managementOfComplication) {
        this.managementOfComplication = managementOfComplication;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getHospitalStays() {
        return hospitalStays;
    }

    public void setHospitalStays(Integer hospitalStays) {
        this.hospitalStays = hospitalStays;
    }

    public String getCaseSummery() {
        return caseSummery;
    }

    public void setCaseSummery(String caseSummery) {
        this.caseSummery = caseSummery;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }
}
