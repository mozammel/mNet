package org.jugbd.mnet.domain;

import javax.persistence.*;

/**
 * @author Bazlur Rahman Rokon
 * @date 11/26/2014.
 */
@Entity
public class BiochemicalInvestigation extends PersistentObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @ManyToOne
    private BiochemicalData blood;

    @ManyToOne
    private BiochemicalData bloodCS;

    @ManyToOne
    private BiochemicalData rbs;

    @ManyToOne
    private BiochemicalData woundS;

    @ManyToOne
    private BiochemicalData creatinine;

    @ManyToOne
    private BiochemicalData sAlbumin;

    @ManyToOne
    private BiochemicalData sTotalProtein;

    @ManyToOne
    private BiochemicalData Electrolyte;

    @ManyToOne
    private BiochemicalData lftSgptAlPhos;

    @ManyToOne
    private BiochemicalData aptt;

    @ManyToOne
    private BiochemicalData pt;

    @ManyToOne
    private BiochemicalData fdpdDimer;

    @ManyToOne
    private BiochemicalData cReactiveProtein;


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

    public BiochemicalData getBlood() {
        return blood;
    }

    public void setBlood(BiochemicalData blood) {
        this.blood = blood;
    }

    public BiochemicalData getBloodCS() {
        return bloodCS;
    }

    public void setBloodCS(BiochemicalData bloodCS) {
        this.bloodCS = bloodCS;
    }

    public BiochemicalData getRbs() {
        return rbs;
    }

    public void setRbs(BiochemicalData rbs) {
        this.rbs = rbs;
    }

    public BiochemicalData getWoundS() {
        return woundS;
    }

    public void setWoundS(BiochemicalData woundS) {
        this.woundS = woundS;
    }

    public BiochemicalData getCreatinine() {
        return creatinine;
    }

    public void setCreatinine(BiochemicalData creatinine) {
        this.creatinine = creatinine;
    }

    public BiochemicalData getsAlbumin() {
        return sAlbumin;
    }

    public void setsAlbumin(BiochemicalData sAlbumin) {
        this.sAlbumin = sAlbumin;
    }

    public BiochemicalData getsTotalProtein() {
        return sTotalProtein;
    }

    public void setsTotalProtein(BiochemicalData sTotalProtein) {
        this.sTotalProtein = sTotalProtein;
    }

    public BiochemicalData getElectrolyte() {
        return Electrolyte;
    }

    public void setElectrolyte(BiochemicalData electrolyte) {
        Electrolyte = electrolyte;
    }

    public BiochemicalData getLftSgptAlPhos() {
        return lftSgptAlPhos;
    }

    public void setLftSgptAlPhos(BiochemicalData lftSgptAlPhos) {
        this.lftSgptAlPhos = lftSgptAlPhos;
    }

    public BiochemicalData getAptt() {
        return aptt;
    }

    public void setAptt(BiochemicalData aptt) {
        this.aptt = aptt;
    }

    public BiochemicalData getPt() {
        return pt;
    }

    public void setPt(BiochemicalData pt) {
        this.pt = pt;
    }

    public BiochemicalData getFdpdDimer() {
        return fdpdDimer;
    }

    public void setFdpdDimer(BiochemicalData fdpdDimer) {
        this.fdpdDimer = fdpdDimer;
    }

    public BiochemicalData getcReactiveProtein() {
        return cReactiveProtein;
    }

    public void setcReactiveProtein(BiochemicalData cReactiveProtein) {
        this.cReactiveProtein = cReactiveProtein;
    }
}
