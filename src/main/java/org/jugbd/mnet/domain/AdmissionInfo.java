package org.jugbd.mnet.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Raqibul Islam on 7/1/14.
 */
@Entity
@Table(name = "admission_info")
public class AdmissionInfo extends Persistence {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.DATE)
    private Date admissionDate;

    @Temporal(TemporalType.DATE)
    private Date injuryDate;

    @Size(max = 32)
    @Column(length = 32)
    private String bedNumber;

    @OneToMany(mappedBy = "admissionInfo")
    private Set<Diagnosis> diagnosisSet = new HashSet<Diagnosis>();

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "ward_info_id")
    private WardInfo wardInfo;

    public AdmissionInfo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getInjuryDate() {
        return injuryDate;
    }

    public void setInjuryDate(Date injuryDate) {
        this.injuryDate = injuryDate;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public Set<Diagnosis> getDiagnosisSet() {
        return diagnosisSet;
    }

    public void setDiagnosisSet(Set<Diagnosis> diagnosisSet) {
        this.diagnosisSet = diagnosisSet;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public WardInfo getWardInfo() {
        return wardInfo;
    }

    public void setWardInfo(WardInfo wardInfo) {
        this.wardInfo = wardInfo;
    }
}
