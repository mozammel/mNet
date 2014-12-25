package org.jugbd.mnet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Raqibul Islam on 7/1/14.
 */
@Entity
public class Diagnosis extends PersistentObject implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private DiagnosisData burns;

    @Size(max = 1000)
    private String congenitalAnomaly;

    @Size(max = 1000)
    private String neoplastic;

    @Size(max = 1000)
    private String postInfective;

    @Size(max = 1000)
    private String traumatic;

    @Size(max = 1000)
    private String aesthetic;

    @Size(max = 1000)
    private String comment;

    @JsonIgnore
    @OneToOne(mappedBy = "diagnosis")
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

    public DiagnosisData getBurns() {
        return burns;
    }

    public void setBurns(DiagnosisData burns) {
        this.burns = burns;
    }

    public String getCongenitalAnomaly() {
        return congenitalAnomaly;
    }

    public void setCongenitalAnomaly(String congenitalAnomaly) {
        this.congenitalAnomaly = congenitalAnomaly;
    }

    public String getNeoplastic() {
        return neoplastic;
    }

    public void setNeoplastic(String neoplastic) {
        this.neoplastic = neoplastic;
    }

    public String getPostInfective() {
        return postInfective;
    }

    public void setPostInfective(String postInfective) {
        this.postInfective = postInfective;
    }

    public String getTraumatic() {
        return traumatic;
    }

    public void setTraumatic(String traumatic) {
        this.traumatic = traumatic;
    }

    public String getAesthetic() {
        return aesthetic;
    }

    public void setAesthetic(String aesthetic) {
        this.aesthetic = aesthetic;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
