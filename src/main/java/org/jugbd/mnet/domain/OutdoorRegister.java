package org.jugbd.mnet.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.jugbd.mnet.domain.enums.Status;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bazlur Rahman Rokon
 * @date 9/12/15.
 */
@Entity
public class OutdoorRegister extends PersistentObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotEmpty(message = "Register id can not be empty")
    private String registrationId;

    @ManyToOne
    private Patient patient;

    @NotNull(message = "Registration can not be empty")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDatetime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date stopDatetime;

    @OneToMany(mappedBy = "register")
    private Set<Vital> vitals = new HashSet<>();

    @OneToMany
    private Set<Visit> visits = new HashSet<>();

    @Column(length = 6)
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn(name = "chief_complaint_id")
    private ChiefComplaint chiefComplaint;

    @OneToOne
    @JoinColumn(name = "examination_id")
    private Examination examination;

    @OneToOne
    @JoinColumn(name = "diagnosis_id")
    private Diagnosis diagnosis;

    @OneToOne
    @JoinColumn(name = "treatment_plan_id")
    private TreatmentPlan treatmentPlan;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "picture_information_id")
    private PictureInformation pictureInformation;

    @Valid
    @Embedded
    private PatientContact patientContact;

    @Lob
    private String outcome;

    @Lob
    private String remarks;

    @Lob
    private String followUpAdvice;

    public String getRegistrationId() {
        return registrationId;
    }

    public OutdoorRegister setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
        return this;
    }

    public Long getId() {
        return id;
    }

    public OutdoorRegister setId(Long id) {
        this.id = id;
        return this;
    }

    public Patient getPatient() {
        return patient;
    }

    public OutdoorRegister setPatient(Patient patient) {
        this.patient = patient;
        return this;
    }

    public Date getStartDatetime() {
        return startDatetime;
    }

    public OutdoorRegister setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
        return this;
    }

    public Date getStopDatetime() {
        return stopDatetime;
    }

    public OutdoorRegister setStopDatetime(Date stopDatetime) {
        this.stopDatetime = stopDatetime;
        return this;
    }

    public Set<Vital> getVitals() {
        return vitals;
    }

    public OutdoorRegister setVitals(Set<Vital> vitals) {
        this.vitals = vitals;
        return this;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public OutdoorRegister setVisits(Set<Visit> visits) {
        this.visits = visits;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public OutdoorRegister setStatus(Status status) {
        this.status = status;
        return this;
    }

    public ChiefComplaint getChiefComplaint() {
        return chiefComplaint;
    }

    public OutdoorRegister setChiefComplaint(ChiefComplaint chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
        return this;
    }

    public Examination getExamination() {
        return examination;
    }

    public OutdoorRegister setExamination(Examination examination) {
        this.examination = examination;
        return this;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public OutdoorRegister setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
        return this;
    }

    public TreatmentPlan getTreatmentPlan() {
        return treatmentPlan;
    }

    public OutdoorRegister setTreatmentPlan(TreatmentPlan treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
        return this;
    }

    public PictureInformation getPictureInformation() {
        return pictureInformation;
    }

    public OutdoorRegister setPictureInformation(PictureInformation pictureInformation) {
        this.pictureInformation = pictureInformation;
        return this;
    }

    public PatientContact getPatientContact() {
        return patientContact;
    }

    public OutdoorRegister setPatientContact(PatientContact patientContact) {
        this.patientContact = patientContact;
        return this;
    }

    public String getOutcome() {
        return outcome;
    }

    public OutdoorRegister setOutcome(String outcome) {
        this.outcome = outcome;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public OutdoorRegister setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public String getFollowUpAdvice() {
        return followUpAdvice;
    }

    public OutdoorRegister setFollowUpAdvice(String followUpAdvice) {
        this.followUpAdvice = followUpAdvice;
        return this;
    }
}
