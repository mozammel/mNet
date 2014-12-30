package org.jugbd.mnet.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/27/14.
 */
@Embeddable
public class PT {
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfInvestigation;

    @Size(max = 100)
    private String patient;

    @Size(max = 100)
    private String control;

    @Size(max = 100)
    private String inIndex;

    @Size(max = 100)
    private String comment;

    public Date getDateOfInvestigation() {
        return dateOfInvestigation;
    }

    public void setDateOfInvestigation(Date dateOfInvestigation) {
        this.dateOfInvestigation = dateOfInvestigation;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getInIndex() {
        return inIndex;
    }

    public void setInIndex(String inIndex) {
        this.inIndex = inIndex;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
