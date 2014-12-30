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
public class CultureAndSensitivity implements Serializable {

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfInvestigation;

    @Size(max = 100)
    private String nameOfOrganism;

    @Size(max = 100)
    private String sensitiveAntibiotic;

    @Size(max = 1000)
    private String comment;

    public Date getDateOfInvestigation() {
        return dateOfInvestigation;
    }

    public void setDateOfInvestigation(Date dateOfInvestigation) {
        this.dateOfInvestigation = dateOfInvestigation;
    }

    public String getNameOfOrganism() {
        return nameOfOrganism;
    }

    public void setNameOfOrganism(String nameOfOrganism) {
        this.nameOfOrganism = nameOfOrganism;
    }

    public String getSensitiveAntibiotic() {
        return sensitiveAntibiotic;
    }

    public void setSensitiveAntibiotic(String sensitiveAntibiotic) {
        this.sensitiveAntibiotic = sensitiveAntibiotic;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
