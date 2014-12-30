package org.jugbd.mnet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Date;

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
    @AttributeOverrides({
            @AttributeOverride(name = "comment", column = @Column(name = "comment_blood_cbc")),
            @AttributeOverride(name = "dateOfInvestigation", column = @Column(name = "date_inv_blood_cbc"))
    })
    private BloodCbc bloodCbc;

    @Valid
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "nameOfOrganism", column = @Column(name = "blood_cbc_name_of_organism")),
            @AttributeOverride(name = "sensitiveAntibiotic", column = @Column(name = "blood_cbc_sensitive_antibiotic")),
            @AttributeOverride(name = "comment", column = @Column(name = "comment_blood_cs")),
            @AttributeOverride(name = "dateOfInvestigation", column = @Column(name = "date_inv_blood_cs")),
    })
    private CultureAndSensitivity bloodCs;

    @Size(max = 100)
    private String rbs;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateRbs;

    @Valid
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "nameOfOrganism", column = @Column(name = "wound_cs_name_of_organism")),
            @AttributeOverride(name = "sensitiveAntibiotic", column = @Column(name = "wound_cs_sensitive_antibiotic")),
            @AttributeOverride(name = "comment", column = @Column(name = "comment_wound_cs")),
            @AttributeOverride(name = "dateOfInvestigation", column = @Column(name = "date_inv_wound_cs")),
    })
    private CultureAndSensitivity woundCs;

    @Size(max = 100)
    private String serumCreatinine;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateSerumCreatinine;

    @Size(max = 100)
    private String serumAlbumin;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateSerumAlbumin;

    @Size(max = 100)
    private String sTotalProtein;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateSTotalProtein;

    @Size(max = 100)
    private String albuminGlobulinRatio;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateAlbuminGlobulinRatio;

    @AttributeOverrides({
            @AttributeOverride(name = "comment", column = @Column(name = "comment_electrolyte")),
            @AttributeOverride(name = "dateOfInvestigation", column = @Column(name = "date_inv_electrolyte"))
    })
    private Electrolyte electrolyte;

    @Size(max = 100)
    private String sgpt;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateSgpt;

    @Size(max = 100)
    private String alphos;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateAlphos;


    @Size(max = 100)
    private String aptt;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateAptt;

    @Valid
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "comment", column = @Column(name = "comment_pt")),
            @AttributeOverride(name = "dateOfInvestigation", column = @Column(name = "date_inv_pt")),
    })
    private PT pt;

    @Size(max = 100)
    private String fdp;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateFdp;

    @Size(max = 100)
    private String dDimer;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateDDimer;

    @Size(max = 100)
    private String cReactiveProtein;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateCReactiveProtein;

    @Size(max = 1000)
    private String xRayUsg;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfXRayUsg;

    @Size(max = 1000)
    private String mriMraCtEchoEcg;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfMriMraCtEchoEcg;

    @Size(max = 1000)
    private String duplexScanDopplerStudy;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfDuplexScanDopplerStudy;

    @Size(max = 1000)
    private String fnacHistopathology;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfFnacHistopathology;

    @Size(max = 1000)
    private String otherInvestigation;

    @JsonIgnore
    @ManyToOne
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

    public Date getDateRbs() {
        return dateRbs;
    }

    public void setDateRbs(Date dateRbs) {
        this.dateRbs = dateRbs;
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

    public Date getDateSerumCreatinine() {
        return dateSerumCreatinine;
    }

    public void setDateSerumCreatinine(Date dateSerumCreatinine) {
        this.dateSerumCreatinine = dateSerumCreatinine;
    }

    public String getSerumAlbumin() {
        return serumAlbumin;
    }

    public void setSerumAlbumin(String serumAlbumin) {
        this.serumAlbumin = serumAlbumin;
    }

    public Date getDateSerumAlbumin() {
        return dateSerumAlbumin;
    }

    public void setDateSerumAlbumin(Date dateSerumAlbumin) {
        this.dateSerumAlbumin = dateSerumAlbumin;
    }

    public String getsTotalProtein() {
        return sTotalProtein;
    }

    public void setsTotalProtein(String sTotalProtein) {
        this.sTotalProtein = sTotalProtein;
    }

    public Date getDateSTotalProtein() {
        return dateSTotalProtein;
    }

    public void setDateSTotalProtein(Date dateSTotalProtein) {
        this.dateSTotalProtein = dateSTotalProtein;
    }

    public String getAlbuminGlobulinRatio() {
        return albuminGlobulinRatio;
    }

    public void setAlbuminGlobulinRatio(String albuminGlobulinRatio) {
        this.albuminGlobulinRatio = albuminGlobulinRatio;
    }

    public Date getDateAlbuminGlobulinRatio() {
        return dateAlbuminGlobulinRatio;
    }

    public void setDateAlbuminGlobulinRatio(Date dateAlbuminGlobulinRatio) {
        this.dateAlbuminGlobulinRatio = dateAlbuminGlobulinRatio;
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

    public Date getDateSgpt() {
        return dateSgpt;
    }

    public void setDateSgpt(Date dateSgpt) {
        this.dateSgpt = dateSgpt;
    }

    public String getAlphos() {
        return alphos;
    }

    public void setAlphos(String alphos) {
        this.alphos = alphos;
    }

    public Date getDateAlphos() {
        return dateAlphos;
    }

    public void setDateAlphos(Date dateAlphos) {
        this.dateAlphos = dateAlphos;
    }

    public String getAptt() {
        return aptt;
    }

    public void setAptt(String aptt) {
        this.aptt = aptt;
    }

    public Date getDateAptt() {
        return dateAptt;
    }

    public void setDateAptt(Date dateAptt) {
        this.dateAptt = dateAptt;
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

    public Date getDateFdp() {
        return dateFdp;
    }

    public void setDateFdp(Date dateFdp) {
        this.dateFdp = dateFdp;
    }

    public String getdDimer() {
        return dDimer;
    }

    public void setdDimer(String dDimer) {
        this.dDimer = dDimer;
    }

    public Date getDateDDimer() {
        return dateDDimer;
    }

    public void setDateDDimer(Date dateDDimer) {
        this.dateDDimer = dateDDimer;
    }

    public String getcReactiveProtein() {
        return cReactiveProtein;
    }

    public void setcReactiveProtein(String cReactiveProtein) {
        this.cReactiveProtein = cReactiveProtein;
    }

    public Date getDateCReactiveProtein() {
        return dateCReactiveProtein;
    }

    public void setDateCReactiveProtein(Date dateCReactiveProtein) {
        this.dateCReactiveProtein = dateCReactiveProtein;
    }

    public String getxRayUsg() {
        return xRayUsg;
    }

    public void setxRayUsg(String xRayUsg) {
        this.xRayUsg = xRayUsg;
    }

    public Date getDateOfXRayUsg() {
        return dateOfXRayUsg;
    }

    public void setDateOfXRayUsg(Date dateOfXRayUsg) {
        this.dateOfXRayUsg = dateOfXRayUsg;
    }

    public String getMriMraCtEchoEcg() {
        return mriMraCtEchoEcg;
    }

    public void setMriMraCtEchoEcg(String mriMraCtEchoEcg) {
        this.mriMraCtEchoEcg = mriMraCtEchoEcg;
    }

    public Date getDateOfMriMraCtEchoEcg() {
        return dateOfMriMraCtEchoEcg;
    }

    public void setDateOfMriMraCtEchoEcg(Date dateOfMriMraCtEchoEcg) {
        this.dateOfMriMraCtEchoEcg = dateOfMriMraCtEchoEcg;
    }

    public String getDuplexScanDopplerStudy() {
        return duplexScanDopplerStudy;
    }

    public void setDuplexScanDopplerStudy(String duplexScanDopplerStudy) {
        this.duplexScanDopplerStudy = duplexScanDopplerStudy;
    }

    public Date getDateOfDuplexScanDopplerStudy() {
        return dateOfDuplexScanDopplerStudy;
    }

    public void setDateOfDuplexScanDopplerStudy(Date dateOfDuplexScanDopplerStudy) {
        this.dateOfDuplexScanDopplerStudy = dateOfDuplexScanDopplerStudy;
    }

    public String getFnacHistopathology() {
        return fnacHistopathology;
    }

    public void setFnacHistopathology(String fnacHistopathology) {
        this.fnacHistopathology = fnacHistopathology;
    }

    public Date getDateOfFnacHistopathology() {
        return dateOfFnacHistopathology;
    }

    public void setDateOfFnacHistopathology(Date dateOfFnacHistopathology) {
        this.dateOfFnacHistopathology = dateOfFnacHistopathology;
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
