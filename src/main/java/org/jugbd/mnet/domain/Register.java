package org.jugbd.mnet.domain;

import org.jugbd.mnet.domain.enums.Status;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bazlur Rahman Rokon on 8/4/14.
 */
@Entity
public class Register extends Persistence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private Long version;

    private String registrationId;

    @OneToMany(mappedBy = "register")
    private Set<Diagnosis> diagnosises = new HashSet<>();

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private AdmissionInfo admissionInfo;
    private Date startDatetime;
    private Date stopDatetime;

    @OneToMany(mappedBy = "register")
    private Set<Vital> vitals;
    @OneToMany(mappedBy = "register")
    private Set<Visit> visits;

    @Column(length = 6)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Embedded
    private PatientContact patientContact;

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

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public Set<Diagnosis> getDiagnosises() {
        return diagnosises;
    }

    public void setDiagnosises(Set<Diagnosis> diagnosises) {
        this.diagnosises = diagnosises;
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

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Date getStopDatetime() {
        return stopDatetime;
    }

    public void setStopDatetime(Date stopDatetime) {
        this.stopDatetime = stopDatetime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<Vital> getVitals() {
        return vitals;
    }

    public void setVitals(Set<Vital> vitals) {
        this.vitals = vitals;
    }

    public PatientContact getPatientContact() {
        return patientContact;
    }

    public void setPatientContact(PatientContact patientContact) {
        this.patientContact = patientContact;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }
}
