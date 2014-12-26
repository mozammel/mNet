package org.jugbd.mnet.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/27/14.
 */
@Embeddable
public class BloodCbc implements Serializable {
    @Size(max = 100)
    private String tc;

    @Size(max = 100)
    private String dc;

    @Size(max = 100)
    private String hb;

    @Size(max = 100)
    private String esr;

    @Size(max = 100)
    private String pcv;

    @Size(max = 1000)
    @Column(name = "blood_cbs_comment")
    private String bloodCbsComment;

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public String getHb() {
        return hb;
    }

    public void setHb(String hb) {
        this.hb = hb;
    }

    public String getEsr() {
        return esr;
    }

    public void setEsr(String esr) {
        this.esr = esr;
    }

    public String getPcv() {
        return pcv;
    }

    public void setPcv(String pcv) {
        this.pcv = pcv;
    }

    public String getBloodCbsComments() {
        return bloodCbsComment;
    }

    public void setBloodCbsComments(String bloodCbsComments) {
        this.bloodCbsComment = bloodCbsComments;
    }
}
