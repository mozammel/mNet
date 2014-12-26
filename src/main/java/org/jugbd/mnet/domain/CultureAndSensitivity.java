package org.jugbd.mnet.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/27/14.
 */
@Embeddable
public class CultureAndSensitivity implements Serializable {
    @Size(max = 100)
    private String nameOfOrganism;

    @Size(max = 100)
    private String sensitiveAntibiotic;

    @Size(max = 1000)
    private String comment;

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
