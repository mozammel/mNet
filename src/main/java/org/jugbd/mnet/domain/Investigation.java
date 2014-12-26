package org.jugbd.mnet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/27/14.
 */
@Entity
public class Investigation extends PersistentObject implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @Valid
    @Embedded
    private BloodCbc bloodCbc;

    @Valid
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "nameOfOrganism", column = @Column(name = "blood_cbc_name_of_organism")),
            @AttributeOverride(name = "sensitiveAntibiotic", column = @Column(name = "blood_cbc_sensitive_antibiotic")),
            @AttributeOverride(name = "comment", column = @Column(name = "blood_cbc_comment"))
    })
    private CultureAndSensitivity bloodCs;

    @Size(max = 100)
    private String rbs;

    @Valid
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "nameOfOrganism", column = @Column(name = "wound_cs_name_of_organism")),
            @AttributeOverride(name = "sensitiveAntibiotic", column = @Column(name = "wound_cs_sensitive_antibiotic")),
            @AttributeOverride(name = "comment", column = @Column(name = "wound_cs_comment"))
    })
    private CultureAndSensitivity woundCs;

    @Size(max = 100)
    private String serumCreatinine;

    @Size(max = 100)
    private String serumAlbumin;

    @Size(max = 100)
    private String sTotalProtein;

    @Size(max = 100)
    private String albuminGlobulinRatio;

    @Size(max = 100)
    @AttributeOverrides({
            @AttributeOverride(name = "comment", column = @Column(name = "electrolyte_comment"))
    })
    private Electrolyte electrolyte;

    @Size(max = 100)
    private String sgpt;

    @Size(max = 100)
    private String alphos;

    @Size(max = 100)
    private String aptt;

    @Valid
    @Embedded
    @Size(max = 100)
    @AttributeOverrides({
            @AttributeOverride(name = "comment", column = @Column(name = "pt_comment"))
    })
    private PT pt;

    @Size(max = 100)
    private String fdp;

    @Size(max = 100)
    private String dDimer;

    @Size(max = 100)
    private String cReactiveProtein;

    @Size(max = 1000)
    private String xRayUsg;

    @Size(max = 1000)
    private String mriMraCtEchoEcg;

    @Size(max = 1000)
    private String duplexScanDopplerStudy;

    @Size(max = 1000)
    private String fnacHistopathology;

    @Size(max = 1000)
    private String otherInvestigation;

    @JsonIgnore
    @OneToOne(mappedBy = "investigation")
    private Register register;

    @Override
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

    public BloodCbc getBloodCbc() {
        return bloodCbc;
    }

    public void setBloodCbc(BloodCbc bloodCbc) {
        this.bloodCbc = bloodCbc;
    }

    public CultureAndSensitivity getBloodCs() {
        return bloodCs;
    }

    public void setBloodCs(CultureAndSensitivity bloodCs) {
        this.bloodCs = bloodCs;
    }

    public String getRbs() {
        return rbs;
    }

    public void setRbs(String rbs) {
        this.rbs = rbs;
    }

    public CultureAndSensitivity getWoundCs() {
        return woundCs;
    }

    public void setWoundCs(CultureAndSensitivity woundCs) {
        this.woundCs = woundCs;
    }

    public String getSerumCreatinine() {
        return serumCreatinine;
    }

    public void setSerumCreatinine(String serumCreatinine) {
        this.serumCreatinine = serumCreatinine;
    }

    public String getSerumAlbumin() {
        return serumAlbumin;
    }

    public void setSerumAlbumin(String serumAlbumin) {
        this.serumAlbumin = serumAlbumin;
    }

    public String getsTotalProtein() {
        return sTotalProtein;
    }

    public void setsTotalProtein(String sTotalProtein) {
        this.sTotalProtein = sTotalProtein;
    }

    public String getAlbuminGlobulinRatio() {
        return albuminGlobulinRatio;
    }

    public void setAlbuminGlobulinRatio(String albuminGlobulinRatio) {
        this.albuminGlobulinRatio = albuminGlobulinRatio;
    }

    public Electrolyte getElectrolyte() {
        return electrolyte;
    }

    public void setElectrolyte(Electrolyte electrolyte) {
        this.electrolyte = electrolyte;
    }

    public String getSgpt() {
        return sgpt;
    }

    public void setSgpt(String sgpt) {
        this.sgpt = sgpt;
    }

    public String getAlphos() {
        return alphos;
    }

    public void setAlphos(String alphos) {
        this.alphos = alphos;
    }

    public String getAptt() {
        return aptt;
    }

    public void setAptt(String aptt) {
        this.aptt = aptt;
    }

    public PT getPt() {
        return pt;
    }

    public void setPt(PT pt) {
        this.pt = pt;
    }

    public String getFdp() {
        return fdp;
    }

    public void setFdp(String fdp) {
        this.fdp = fdp;
    }

    public String getdDimer() {
        return dDimer;
    }

    public void setdDimer(String dDimer) {
        this.dDimer = dDimer;
    }

    public String getcReactiveProtein() {
        return cReactiveProtein;
    }

    public void setcReactiveProtein(String cReactiveProtein) {
        this.cReactiveProtein = cReactiveProtein;
    }

    public String getxRayUsg() {
        return xRayUsg;
    }

    public void setxRayUsg(String xRayUsg) {
        this.xRayUsg = xRayUsg;
    }

    public String getMriMraCtEchoEcg() {
        return mriMraCtEchoEcg;
    }

    public void setMriMraCtEchoEcg(String mriMraCtEchoEcg) {
        this.mriMraCtEchoEcg = mriMraCtEchoEcg;
    }

    public String getDuplexScanDopplerStudy() {
        return duplexScanDopplerStudy;
    }

    public void setDuplexScanDopplerStudy(String duplexScanDopplerStudy) {
        this.duplexScanDopplerStudy = duplexScanDopplerStudy;
    }

    public String getFnacHistopathology() {
        return fnacHistopathology;
    }

    public void setFnacHistopathology(String fnacHistopathology) {
        this.fnacHistopathology = fnacHistopathology;
    }

    public String getOtherInvestigation() {
        return otherInvestigation;
    }

    public void setOtherInvestigation(String otherInvestigation) {
        this.otherInvestigation = otherInvestigation;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }
}
