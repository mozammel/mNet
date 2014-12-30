package org.jugbd.mnet.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/27/14.
 */

@Embeddable
public class Electrolyte implements Serializable {
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfInvestigation;

    @Size(max = 100)
    private String sodium;

    @Size(max = 100)
    private String chlorine;

    @Size(max = 100)
    private String potassium;

    @Size(max = 100)
    private String bicarbonate;

    @Size(max = 100)
    private String calcium;

    @Size(max = 100)
    private String comment;

    public Date getDateOfInvestigation() {
        return dateOfInvestigation;
    }

    public void setDateOfInvestigation(Date dateOfInvestigation) {
        this.dateOfInvestigation = dateOfInvestigation;
    }

    public String getSodium() {
        return sodium;
    }

    public void setSodium(String sodium) {
        this.sodium = sodium;
    }

    public String getPotassium() {
        return potassium;
    }

    public void setPotassium(String potassium) {
        this.potassium = potassium;
    }

    public String getChlorine() {
        return chlorine;
    }

    public void setChlorine(String chlorine) {
        this.chlorine = chlorine;
    }

    public String getBicarbonate() {
        return bicarbonate;
    }

    public void setBicarbonate(String bicarbonate) {
        this.bicarbonate = bicarbonate;
    }

    public String getCalcium() {
        return calcium;
    }

    public void setCalcium(String calcium) {
        this.calcium = calcium;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
