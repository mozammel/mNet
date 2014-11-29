package org.jugbd.mnet.domain;

import javax.persistence.*;

/**
 * Created by Raqibul Islam on 7/1/14.
 */
@Entity
public class Diagnosis extends PersistentObject {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @OneToOne
    private DiagnosisData burns;

    @OneToOne
    private DiagnosisData congenitalAnomaly;

    @OneToOne
    private DiagnosisData neoplastic;

    @OneToOne
    private DiagnosisData postInfective;

    @OneToOne
    private DiagnosisData traumatic;

    @OneToOne
    private DiagnosisData aesthetic;

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
}
