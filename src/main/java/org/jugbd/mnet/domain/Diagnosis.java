package org.jugbd.mnet.domain;

import javax.persistence.*;

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

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private DiagnosisData congenitalAnomaly;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private DiagnosisData neoplastic;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private DiagnosisData postInfective;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private DiagnosisData traumatic;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private DiagnosisData aesthetic;

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

    public DiagnosisData getCongenitalAnomaly() {
        return congenitalAnomaly;
    }

    public void setCongenitalAnomaly(DiagnosisData congenitalAnomaly) {
        this.congenitalAnomaly = congenitalAnomaly;
    }

    public DiagnosisData getNeoplastic() {
        return neoplastic;
    }

    public void setNeoplastic(DiagnosisData neoplastic) {
        this.neoplastic = neoplastic;
    }

    public DiagnosisData getPostInfective() {
        return postInfective;
    }

    public void setPostInfective(DiagnosisData postInfective) {
        this.postInfective = postInfective;
    }

    public DiagnosisData getTraumatic() {
        return traumatic;
    }

    public void setTraumatic(DiagnosisData traumatic) {
        this.traumatic = traumatic;
    }

    public DiagnosisData getAesthetic() {
        return aesthetic;
    }

    public void setAesthetic(DiagnosisData aesthetic) {
        this.aesthetic = aesthetic;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }
}
