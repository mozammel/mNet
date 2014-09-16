package org.jugbd.mnet.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.jugbd.mnet.domain.enums.Relationship;
import org.jugbd.mnet.domain.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @OneToMany(mappedBy = "register", fetch = FetchType.EAGER)
    private Set<Diagnosis> diagnosises = new HashSet<>();
    @ManyToOne
    private Patient patient;
    private AdmissionInfo admissionInfo;
    private Date startDatetime;
    private Date stopDatetime;
    private Vital vital;
    @Column(length = 6)
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotEmpty
    @Size(max = 100)
    @Column(length = 100)
    private String contactPerson;

    @NotNull
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Relationship relationship;

    @NotEmpty
    @Size(max = 32)
    @Column(length = 32)
    private String emergencyContactNumber;

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

    public Vital getVital() {
        return vital;
    }

    public void setVital(Vital vital) {
        this.vital = vital;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }
}
