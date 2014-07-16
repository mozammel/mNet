package org.jugbd.mnet.domain;

import org.jugbd.mnet.domain.enums.BloodType;
import org.jugbd.mnet.domain.enums.Gender;
import org.jugbd.mnet.domain.enums.Relationship;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Raqibul Islam on 7/1/14.
 */
@Entity
@Table(name = "patient")
public class Patient extends Persistence {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 32)
    @Column(length = 32)
    private String healthId;

    @Size(max = 100)
    @Column(length = 100)
    private String name;

    @Size(max = 128)
    @Column(length = 128)
    private String careOfAddress;

    private Integer age;

    @Column(length = 6)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 16)
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    private Double height;

    private Double weight;

    @Size(max = 32)
    @Column(length = 32)
    private String contactNumber;

    @Size(max = 100)
    @Column(length = 100)
    private String contactPerson;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Relationship relationship;

    @Size(max = 32)
    @Column(length = 32)
    private String emergencyContactNumber;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "patient")
    private Set<AdmissionInfo> admissionInfoSet = new HashSet<AdmissionInfo>();

    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHealthId() {
        return healthId;
    }

    public void setHealthId(String healthId) {
        this.healthId = healthId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCareOfAddress() {
        return careOfAddress;
    }

    public void setCareOfAddress(String careOfAddress) {
        this.careOfAddress = careOfAddress;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<AdmissionInfo> getAdmissionInfoSet() {
        return admissionInfoSet;
    }

    public void setAdmissionInfoSet(Set<AdmissionInfo> admissionInfoSet) {
        this.admissionInfoSet = admissionInfoSet;
    }
}
