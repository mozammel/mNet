package org.jugbd.mnet.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Raqibul Islam on 7/1/14.
 */
@Entity
@Table(name = "diagnosis")
public class Diagnosis extends Persistence {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @Temporal(TemporalType.DATE)
    private Date entryDate;

    @NotEmpty
    @Size(max = 3000)
    @Column(length = 3000)
    private String chiefComplain;

    @NotEmpty
    @Size(max = 3000)
    @Column(length = 3000)
    private String presentIllness;

    @NotEmpty
    @Size(max = 3000)
    @Column(length = 3000)
    private String associatedSymptoms;

    @NotEmpty
    @Size(max = 3000)
    @Column(length = 3000)
    private String physicalExamination;

    @NotEmpty
    @Size(max = 3000)
    @Column(length = 3000)
    private String systemicExamination;

    @NotEmpty
    @Size(max = 3000)
    @Column(length = 3000)
    private String pictureInformation;

    @NotEmpty
    @Size(max = 3000)
    @Column(length = 3000)
    private String plan;

    @ManyToOne(fetch = FetchType.EAGER)
    private AdmissionInfo admissionInfo;

    public Diagnosis() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getChiefComplain() {
        return chiefComplain;
    }

    public void setChiefComplain(String chiefComplain) {
        this.chiefComplain = chiefComplain;
    }

    public String getPresentIllness() {
        return presentIllness;
    }

    public void setPresentIllness(String presentIllness) {
        this.presentIllness = presentIllness;
    }

    public String getAssociatedSymptoms() {
        return associatedSymptoms;
    }

    public void setAssociatedSymptoms(String associatedSymptoms) {
        this.associatedSymptoms = associatedSymptoms;
    }

    public String getPhysicalExamination() {
        return physicalExamination;
    }

    public void setPhysicalExamination(String physicalExamination) {
        this.physicalExamination = physicalExamination;
    }

    public String getSystemicExamination() {
        return systemicExamination;
    }

    public void setSystemicExamination(String systemicExamination) {
        this.systemicExamination = systemicExamination;
    }

    public String getPictureInformation() {
        return pictureInformation;
    }

    public void setPictureInformation(String pictureInformation) {
        this.pictureInformation = pictureInformation;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public AdmissionInfo getAdmissionInfo() {
        return admissionInfo;
    }

    public void setAdmissionInfo(AdmissionInfo admissionInfo) {
        this.admissionInfo = admissionInfo;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "plan='" + plan + '\'' +
                ", pictureInformation='" + pictureInformation + '\'' +
                ", systemicExamination='" + systemicExamination + '\'' +
                ", physicalExamination='" + physicalExamination + '\'' +
                ", associatedSymptoms='" + associatedSymptoms + '\'' +
                ", presentIllness='" + presentIllness + '\'' +
                ", chiefComplain='" + chiefComplain + '\'' +
                ", entryDate=" + entryDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Diagnosis diagnosis = (Diagnosis) o;

        if (admissionInfo != null ? !admissionInfo.equals(diagnosis.admissionInfo) : diagnosis.admissionInfo != null)
            return false;
        if (associatedSymptoms != null ? !associatedSymptoms.equals(diagnosis.associatedSymptoms) : diagnosis.associatedSymptoms != null)
            return false;
        if (chiefComplain != null ? !chiefComplain.equals(diagnosis.chiefComplain) : diagnosis.chiefComplain != null)
            return false;
        if (entryDate != null ? !entryDate.equals(diagnosis.entryDate) : diagnosis.entryDate != null) return false;
        if (id != null ? !id.equals(diagnosis.id) : diagnosis.id != null) return false;
        if (physicalExamination != null ? !physicalExamination.equals(diagnosis.physicalExamination) : diagnosis.physicalExamination != null)
            return false;
        if (pictureInformation != null ? !pictureInformation.equals(diagnosis.pictureInformation) : diagnosis.pictureInformation != null)
            return false;
        if (plan != null ? !plan.equals(diagnosis.plan) : diagnosis.plan != null) return false;
        if (presentIllness != null ? !presentIllness.equals(diagnosis.presentIllness) : diagnosis.presentIllness != null)
            return false;
        if (systemicExamination != null ? !systemicExamination.equals(diagnosis.systemicExamination) : diagnosis.systemicExamination != null)
            return false;
        if (version != null ? !version.equals(diagnosis.version) : diagnosis.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (entryDate != null ? entryDate.hashCode() : 0);
        result = 31 * result + (chiefComplain != null ? chiefComplain.hashCode() : 0);
        result = 31 * result + (presentIllness != null ? presentIllness.hashCode() : 0);
        result = 31 * result + (associatedSymptoms != null ? associatedSymptoms.hashCode() : 0);
        result = 31 * result + (physicalExamination != null ? physicalExamination.hashCode() : 0);
        result = 31 * result + (systemicExamination != null ? systemicExamination.hashCode() : 0);
        result = 31 * result + (pictureInformation != null ? pictureInformation.hashCode() : 0);
        result = 31 * result + (plan != null ? plan.hashCode() : 0);
        result = 31 * result + (admissionInfo != null ? admissionInfo.hashCode() : 0);
        return result;
    }
}
