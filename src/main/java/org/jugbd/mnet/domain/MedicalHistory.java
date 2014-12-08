package org.jugbd.mnet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jugbd.mnet.domain.enums.MenstrualCycle;
import org.jugbd.mnet.domain.enums.PastMedicalHistory;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author Bazlur Rahman Rokon
 * @date 11/26/2014.
 */
@Entity
public class MedicalHistory extends PersistentObject implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @Column(length = 6)
    @Enumerated(EnumType.STRING)
    private PastMedicalHistory pastMedicalHistory;
    //Menstrual History
    @Column(nullable = true)
    private Integer period;

    @Column(nullable = true)
    private Integer days;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private MenstrualCycle menstrualCycle;

    @Size(max = 1000)
    private String pastSurgicalHistory;

    @Size(max = 1000)
    private String drugHistory;

    @Size(max = 1000)
    private String familyHistory;
    private Boolean similarDiseasesInFamily;

    private String presentIllness;

    @JsonIgnore
    @OneToOne(mappedBy = "medicalHistory")
    private Register register;

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

    public PastMedicalHistory getPastMedicalHistory() {
        return pastMedicalHistory;
    }

    public void setPastMedicalHistory(PastMedicalHistory pastMedicalHistory) {
        this.pastMedicalHistory = pastMedicalHistory;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public MenstrualCycle getMenstrualCycle() {
        return menstrualCycle;
    }

    public void setMenstrualCycle(MenstrualCycle menstrualCycle) {
        this.menstrualCycle = menstrualCycle;
    }

    public String getPastSurgicalHistory() {
        return pastSurgicalHistory;
    }

    public void setPastSurgicalHistory(String pastSurgicalHistory) {
        this.pastSurgicalHistory = pastSurgicalHistory;
    }

    public String getDrugHistory() {
        return drugHistory;
    }

    public void setDrugHistory(String drugHistory) {
        this.drugHistory = drugHistory;
    }

    public String getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
    }

    public Boolean getSimilarDiseasesInFamily() {
        return similarDiseasesInFamily;
    }

    public void setSimilarDiseasesInFamily(Boolean similarDiseasesInFamily) {
        this.similarDiseasesInFamily = similarDiseasesInFamily;
    }

    public String getPresentIllness() {
        return presentIllness;
    }

    public void setPresentIllness(String presentIllness) {
        this.presentIllness = presentIllness;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    @Override
    public String toString() {
        return "MedicalHistory{" +
                "id=" + id +
                ", version=" + version +
                ", pastMedicalHistory=" + pastMedicalHistory +
                ", period=" + period +
                ", days=" + days +
                ", menstrualCycle=" + menstrualCycle +
                ", pastSurgicalHistory='" + pastSurgicalHistory + '\'' +
                ", drugHistory='" + drugHistory + '\'' +
                ", familyHistory='" + familyHistory + '\'' +
                ", similarDiseasesInFamily=" + similarDiseasesInFamily +
                '}';
    }
}
