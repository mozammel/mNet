package org.jugbd.mnet.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

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

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "admission_info_id")
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public AdmissionInfo getAdmissionInfo() {
        return admissionInfo;
    }

    public void setAdmissionInfo(AdmissionInfo admissionInfo) {
        this.admissionInfo = admissionInfo;
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
}
