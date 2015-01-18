package org.jugbd.mnet.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;
import org.jugbd.mnet.domain.enums.RequiredNotRequired;
import org.jugbd.mnet.domain.enums.YesNo;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/26/14.
 */
@Entity
@JsonIgnoreProperties({"register"})
public class OperationalDetail extends PersistentObject implements Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @DateTimeFormat(pattern = "MM/dd/yyyy hh:mm a")
    private Date dateTime;

    @NotEmpty
    private String anaesthesia;

    @NotEmpty
    private String nameOfOperation;
    private String indication;

    @NotEmpty
    private String nameOfSurgeon;

    @NotEmpty
    private String nameOfAnaesthetist;
    private String findings;
    private String incision;
    private String donorSite;
    private String plasty;
    private String recipientSite;

    @NotNull
    @Column(length = 15)
    @Enumerated(EnumType.STRING)
    private RequiredNotRequired bloodTransfusion; // Required- Not Required

    @NotNull
    @Column(length = 5)
    @Enumerated(EnumType.STRING)
    private YesNo drain;

    @Size(max = 1000)
    private String comment;

    @ManyToOne
    private Register register;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
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

    public RequiredNotRequired getBloodTransfusion() {
        return bloodTransfusion;
    }

    public void setBloodTransfusion(RequiredNotRequired bloodTransfusion) {
        this.bloodTransfusion = bloodTransfusion;
    }

    public YesNo getDrain() {
        return drain;
    }

    public void setDrain(YesNo drain) {
        this.drain = drain;
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
