package org.jugbd.mnet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author Bazlur Rahman Rokon
 * @date 11/26/2014.
 */
@Entity
public class Examination extends PersistentObject implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    //General Examination
    private Boolean anaemia;
    private Boolean jaundice;
    private Boolean accessibleLymphNode;
    private Boolean dehydration;
    private Boolean oelema;
    private Boolean neckVein;

    @Size(max = 1000)
    private String gExaminationComments;

    @Column(length = 1000)
    @Size(max = 1000)
    private String listeningExamination;
    //Systemic Examination
    @Size(max = 1000)
    private String respiratorySystem;

    @Size(max = 1000)
    private String gISystem;

    @Size(max = 1000)
    private String cardiovascularSystem;

    @Size(max = 1000)
    private String urogenitalSystem;

    @Size(max = 1000)
    private String nervousSystem;

    @JsonIgnore
    @OneToOne(mappedBy = "examination")
    private Register register;

    @JsonIgnore
    @OneToOne(mappedBy = "examination")
    private OutdoorRegister outdoorRegister;

    @Size(max = 1000)
    private String comments;

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

    public Boolean getAnaemia() {
        return anaemia;
    }

    public void setAnaemia(Boolean anaemia) {
        this.anaemia = anaemia;
    }

    public Boolean getJaundice() {
        return jaundice;
    }

    public void setJaundice(Boolean jaundice) {
        this.jaundice = jaundice;
    }

    public Boolean getAccessibleLymphNode() {
        return accessibleLymphNode;
    }

    public void setAccessibleLymphNode(Boolean accessibleLymphNode) {
        this.accessibleLymphNode = accessibleLymphNode;
    }

    public Boolean getDehydration() {
        return dehydration;
    }

    public void setDehydration(Boolean dehydration) {
        this.dehydration = dehydration;
    }

    public Boolean getOelema() {
        return oelema;
    }

    public void setOelema(Boolean oelema) {
        this.oelema = oelema;
    }

    public Boolean getNeckVein() {
        return neckVein;
    }

    public void setNeckVein(Boolean neckVein) {
        this.neckVein = neckVein;
    }

    public String getgExaminationComments() {
        return gExaminationComments;
    }

    public void setgExaminationComments(String gExaminationComments) {
        this.gExaminationComments = gExaminationComments;
    }

    public String getListeningExamination() {
        return listeningExamination;
    }

    public void setListeningExamination(String listeningExamination) {
        this.listeningExamination = listeningExamination;
    }

    public String getRespiratorySystem() {
        return respiratorySystem;
    }

    public void setRespiratorySystem(String respiratorySystem) {
        this.respiratorySystem = respiratorySystem;
    }

    public String getgISystem() {
        return gISystem;
    }

    public void setgISystem(String gISystem) {
        this.gISystem = gISystem;
    }

    public String getCardiovascularSystem() {
        return cardiovascularSystem;
    }

    public void setCardiovascularSystem(String cardiovascularSystem) {
        this.cardiovascularSystem = cardiovascularSystem;
    }

    public String getUrogenitalSystem() {
        return urogenitalSystem;
    }

    public void setUrogenitalSystem(String urogenitalSystem) {
        this.urogenitalSystem = urogenitalSystem;
    }

    public String getNervousSystem() {
        return nervousSystem;
    }

    public void setNervousSystem(String nervousSystem) {
        this.nervousSystem = nervousSystem;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public OutdoorRegister getOutdoorRegister() {
        return outdoorRegister;
    }

    public Examination setOutdoorRegister(OutdoorRegister outdoorRegister) {
        this.outdoorRegister = outdoorRegister;
        return this;
    }
}
