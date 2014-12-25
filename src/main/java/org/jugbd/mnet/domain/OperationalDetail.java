package org.jugbd.mnet.domain;

import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/26/14.
 */
@Entity
public class OperationalDetail extends PersistentObject implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private DateTime dateTime;
    private String anaesthesia;
    private String nameOfOperation;
    private String indication;
    private String nameOfSurgeon;
    private String nameOfAnaesthetist;
    private String findings;
    private String incision;
    private String donorSite;
    private String plasty;
    private String recipientSite;
    private Boolean bloodTransfusion; // Required- Not Required
    private Boolean drain;

    @ManyToOne
    private Register register;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getAnaesthesia() {
        return anaesthesia;
    }

    public void setAnaesthesia(String anaesthesia) {
        this.anaesthesia = anaesthesia;
    }

    public String getNameOfOperation() {
        return nameOfOperation;
    }

    public void setNameOfOperation(String nameOfOperation) {
        this.nameOfOperation = nameOfOperation;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getNameOfSurgeon() {
        return nameOfSurgeon;
    }

    public void setNameOfSurgeon(String nameOfSurgeon) {
        this.nameOfSurgeon = nameOfSurgeon;
    }

    public String getNameOfAnaesthetist() {
        return nameOfAnaesthetist;
    }

    public void setNameOfAnaesthetist(String nameOfAnaesthetist) {
        this.nameOfAnaesthetist = nameOfAnaesthetist;
    }

    public String getFindings() {
        return findings;
    }

    public void setFindings(String findings) {
        this.findings = findings;
    }

    public String getIncision() {
        return incision;
    }

    public void setIncision(String incision) {
        this.incision = incision;
    }

    public String getDonorSite() {
        return donorSite;
    }

    public void setDonorSite(String donorSite) {
        this.donorSite = donorSite;
    }

    public String getPlasty() {
        return plasty;
    }

    public void setPlasty(String plasty) {
        this.plasty = plasty;
    }

    public String getRecipientSite() {
        return recipientSite;
    }

    public void setRecipientSite(String recipientSite) {
        this.recipientSite = recipientSite;
    }

    public Boolean getBloodTransfusion() {
        return bloodTransfusion;
    }

    public void setBloodTransfusion(Boolean bloodTransfusion) {
        this.bloodTransfusion = bloodTransfusion;
    }

    public Boolean getDrain() {
        return drain;
    }

    public void setDrain(Boolean drain) {
        this.drain = drain;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }
}
