package org.jugbd.mnet.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/27/14.
 */

@Embeddable
public class Electrolyte implements Serializable {
    @Size(max = 100)
    private String sodium;

    @Size(max = 100)
    private String chlorine;

    @Size(max = 100)
    private String bicarbonate;

    @Size(max = 100)
    private String calcium;

    @Size(max = 100)
    private String comment;

    public String getSodium() {
        return sodium;
    }

    public void setSodium(String sodium) {
        this.sodium = sodium;
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
