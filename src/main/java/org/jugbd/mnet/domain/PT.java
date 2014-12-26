package org.jugbd.mnet.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/27/14.
 */
@Embeddable
public class PT {
    @Size(max = 100)
    private String patient;

    @Size(max = 100)
    private String control;

    @Size(max = 100)
    private String inIndex;

    @Size(max = 100)
    private String comment;

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
