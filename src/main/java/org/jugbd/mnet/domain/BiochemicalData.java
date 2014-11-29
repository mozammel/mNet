package org.jugbd.mnet.domain;

import javax.persistence.*;

/**
 * @author Bazlur Rahman Rokon
 * @date 11/26/2014.
 */
@Entity
public class BiochemicalData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    private String cbc;
    private String hb;
    private String esr;

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

    public String getCbc() {
        return cbc;
    }

    public void setCbc(String cbc) {
        this.cbc = cbc;
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
}
