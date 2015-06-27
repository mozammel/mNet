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

    public void setPatient(Patient patient) {
        this.patient = patient;
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

    public void setRegister(Register register) {
        this.register = register;
    }
}
