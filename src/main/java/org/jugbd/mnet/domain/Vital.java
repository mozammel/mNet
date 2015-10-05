package org.jugbd.mnet.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.jugbd.mnet.domain.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Bazlur Rahman Rokon on 8/4/14.
 */
@Entity
@JsonIgnoreProperties({"register"})
public class Vital extends PersistentObject implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    private Double height;  //Height (cm)
    private Double weight;  //Weight (kg)
    private Double bmi;     //(Calculated) BMI

    @NotNull
    private Double temperature;     //Temperature (F)
    private Integer pulse;          //Pulse per minute
    private Integer respiratoryRate; //Respiratory rate per minute

    @NotNull
    private Integer systolic;  //Blood Pressure

    @NotNull
    private Integer diastolic;
    private Double bloodOxygenSaturation;//Blood oxygen saturation

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

    @ManyToOne
    private Register register;

    @ManyToOne
    private OutdoorRegister outdoorRegister;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Status status;

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

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    public Integer getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(Integer respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public Integer getSystolic() {
        return systolic;
    }

    public void setSystolic(Integer systolic) {
        this.systolic = systolic;
    }

    public Integer getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(Integer diastolic) {
        this.diastolic = diastolic;
    }

    public Double getBloodOxygenSaturation() {
        return bloodOxygenSaturation;
    }

    public void setBloodOxygenSaturation(Double bloodOxygenSaturation) {
        this.bloodOxygenSaturation = bloodOxygenSaturation;
    }

    public Patient getPatient() {
        return patient;
    }

    public Vital setPatient(Patient patient) {
        this.patient = patient;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Register getRegister() {
        return register;
    }

    public Vital setRegister(Register register) {
        this.register = register;
        return this;
    }

    public OutdoorRegister getOutdoorRegister() {
        return outdoorRegister;
    }

    public Vital setOutdoorRegister(OutdoorRegister outdoorRegister) {
        this.outdoorRegister = outdoorRegister;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Vital{");
        sb.append("id=").append(id);
        sb.append(", version=").append(version);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", bmi=").append(bmi);
        sb.append(", temperature=").append(temperature);
        sb.append(", pulse=").append(pulse);
        sb.append(", respiratoryRate=").append(respiratoryRate);
        sb.append(", systolic=").append(systolic);
        sb.append(", diastolic=").append(diastolic);
        sb.append(", bloodOxygenSaturation=").append(bloodOxygenSaturation);
        sb.append(", patient=").append(patient);
        sb.append(", register=").append(register);
        sb.append(", outdoorRegister=").append(outdoorRegister);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
