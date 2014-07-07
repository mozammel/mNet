package org.jugbd.mnet.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author raqibul
 * @since 7/1/14 1:46 PM
 */
@Entity
@Table(name = "diagnosis")
public class Diagnosis {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(max = 256)
    @Column(length = 256)
    private String chiefComplain;

    @Size(max = 256)
    @Column(length = 256)
    private String presentIllness;

    @Size(max = 256)
    @Column(length = 256)
    private String associatedSymptoms;

    @Size(max = 256)
    @Column(length = 256)
    private String physicalExamination;

    @Size(max = 256)
    @Column(length = 256)
    private String systemicExamination;

    @Size(max = 256)
    @Column(length = 256)
    private String pictureInformation;

    @Size(max = 256)
    @Column(length = 256)
    private String plan;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "admission_info_id")
    private AdmissionInfo admissionInfo;

    public Diagnosis() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
