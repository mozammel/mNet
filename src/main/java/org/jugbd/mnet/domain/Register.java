package org.jugbd.mnet.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.jugbd.mnet.domain.enums.Status;
import org.jugbd.mnet.domain.enums.Ward;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bazlur Rahman Rokon
 * @since 8/4/14.
 */
@Entity
public class Register extends PersistentObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @NotNull
    @NotEmpty
    private String registrationId;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date admissionDate;

    @NotNull
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Ward ward;

    @Size(max = 100)
    @Column(length = 100)
    private String wardOther;

    @NotEmpty
    @Size(max = 32)
    @Column(length = 32)
    private String bedNumber;

    @NotEmpty
    @Size(max = 32)
    @Column(length = 32)
    private String unit;

    @ManyToOne
    private Patient patient;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDatetime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date stopDatetime;

    @OneToMany(mappedBy = "register")
    private Set<Vital> vitals = new HashSet<>();

    @OneToMany(mappedBy = "register")
    private Set<OperationalDetail> operationalDetails = new HashSet<>();

    @OneToMany
    private Set<Visit> visits;

    @Column(length = 6)
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn(name = "medical_history_id")
    private MedicalHistory medicalHistory;

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

    @OneToOne
    @JoinColumn(name = "complication_management")
    private ComplicationManagement complicationManagement;

    @OneToOne
    @JoinColumn(name = "life_style_id")
    private LifeStyle lifeStyle;

    @OneToOne
    @JoinColumn(name = "investigation_id")
    private Investigation investigation;

    @Valid
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

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public String getWardOther() {
        return wardOther;
    }

    public void setWardOther(String wardOther) {
        this.wardOther = wardOther;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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

    public Set<Vital> getVitals() {
        return vitals;
    }

    public void setVitals(Set<Vital> vitals) {
        this.vitals = vitals;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    public Set<OperationalDetail> getOperationalDetails() {
        return operationalDetails;
    }

    public void setOperationalDetails(Set<OperationalDetail> operationalDetails) {
        this.operationalDetails = operationalDetails;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public ChiefComplaint getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(ChiefComplaint chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    public Examination getExamination() {
        return examination;
    }

    public void setExamination(Examination examination) {
        this.examination = examination;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public TreatmentPlan getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setTreatmentPlan(TreatmentPlan treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public PatientContact getPatientContact() {
        return patientContact;
    }

    public void setPatientContact(PatientContact patientContact) {
        this.patientContact = patientContact;
    }

    public ComplicationManagement getComplicationManagement() {
        return complicationManagement;
    }

    public void setComplicationManagement(ComplicationManagement complicationManagement) {
        this.complicationManagement = complicationManagement;
    }

    public LifeStyle getLifeStyle() {
        return lifeStyle;
    }

    public void setLifeStyle(LifeStyle lifeStyle) {
        this.lifeStyle = lifeStyle;
    }

    public Investigation getInvestigation() {
        return investigation;
    }

    public void setInvestigation(Investigation investigation) {
        this.investigation = investigation;
    }
}
