package org.jugbd.mnet.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.jugbd.mnet.domain.enums.BloodType;
import org.jugbd.mnet.domain.enums.Gender;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.Date;
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

    @NotEmpty
    @Size(max = 100)
    @Column(length = 100)
    private String name;

    @Size(max = 128)
    @Column(length = 128)
    private String careOfAddress;

    @Past
    private Date dateOfBirth;

    @Max(150)
    private Integer age;

    @Column(length = 6)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 16)
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    //private Double height;

    //private Double weight;

    @NotEmpty
    @Size(max = 32)
    @Column(length = 32)
    private String contactNumber;
//
//    @Size(max = 100)
//    @Column(length = 100)
//    private String contactPerson;
//
//    @Column(length = 10)
//    @Enumerated(EnumType.STRING)
//    private Relationship relationship;
//
//    @Size(max = 32)
//    @Column(length = 32)
//    private String emergencyContactNumber;

    @Embedded
    @NotNull
    private Address address;
    private Boolean dead = false;
    private Date deathDate;
    @Transient
    private Integer ageEstimated;
    private Boolean birthdateEstimated = false;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "patient", cascade = CascadeType.ALL)
//    private Set<AdmissionInfo> admissionInfos = new HashSet<>();

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private Set<Register> registers = new HashSet<>();

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
        return getAge(null);
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
//
//    public Double getHeight() {
//        return height;
//    }
//
//    public void setHeight(Double height) {
//        this.height = height;
//    }
//
//    public Double getWeight() {
//        return weight;
//    }
//
//    public void setWeight(Double weight) {
//        this.weight = weight;
//    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
//
//    public String getContactPerson() {
//        return contactPerson;
//    }
//
//    public void setContactPerson(String contactPerson) {
//        this.contactPerson = contactPerson;
//    }
//
//    public Relationship getRelationship() {
//        return relationship;
//    }
//
//    public void setRelationship(Relationship relationship) {
//        this.relationship = relationship;
//    }
//
//    public String getEmergencyContactNumber() {
//        return emergencyContactNumber;
//    }
//
//    public void setEmergencyContactNumber(String emergencyContactNumber) {
//        this.emergencyContactNumber = emergencyContactNumber;
//    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

//    public Set<AdmissionInfo> getAdmissionInfos() {
//        return admissionInfos;
//    }
//
//    public void setAdmissionInfos(Set<AdmissionInfo> admissionInfos) {
//        this.admissionInfos = admissionInfos;
//    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getDead() {
        return dead;
    }

    public void setDead(Boolean dead) {
        this.dead = dead;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    /**
     * Calculates the person's age on a given date based on the dateOfBirth
     *
     * @param onDate (null defaults to today)
     * @return int value of the person's age
     */
    public Integer getAge(Date onDate) {
        if (dateOfBirth == null) {
            return null;
        }

        // Use default end date as today.
        Calendar today = Calendar.getInstance();
        // But if given, use the given date.
        if (onDate != null) {
            today.setTime(onDate);
        }

        // If date given is after date of death then use date of death as end date
        if (getDeathDate() != null && today.getTime().after(getDeathDate())) {
            today.setTime(getDeathDate());
        }

        Calendar bday = Calendar.getInstance();
        bday.setTime(dateOfBirth);

        int age = today.get(Calendar.YEAR) - bday.get(Calendar.YEAR);

        // Adjust age when today's date is before the person's birthday
        int todaysMonth = today.get(Calendar.MONTH);
        int bdayMonth = bday.get(Calendar.MONTH);
        int todaysDay = today.get(Calendar.DAY_OF_MONTH);
        int bdayDay = bday.get(Calendar.DAY_OF_MONTH);

        if (todaysMonth < bdayMonth) {
            age--;
        } else if (todaysMonth == bdayMonth && todaysDay < bdayDay) {
            // we're only comparing on month and day, not minutes, etc
            age--;
        }

        return age;
    }

    /**
     * Sets a Patient's birth date from an age as of the given date Also sets
     * flag indicating that the birth date is inexact. This sets the Patient's birth date to January
     * 1 of the year that matches this age and date
     *
     * @param age (the age to set)
     * @param ageOnDate (null defaults to today)
     */
    public void setBirthdateFromAge(int age, Date ageOnDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(ageOnDate == null ? new Date() : ageOnDate);
        c.set(Calendar.DATE, 1);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.add(Calendar.YEAR, -1 * age);
        setDateOfBirth(c.getTime());
        setBirthdateEstimated(true);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (address != null ? !address.equals(patient.address) : patient.address != null) return false;
        if (age != null ? !age.equals(patient.age) : patient.age != null) return false;
        if (bloodType != patient.bloodType) return false;
        if (careOfAddress != null ? !careOfAddress.equals(patient.careOfAddress) : patient.careOfAddress != null)
            return false;
//        if (contactNumber != null ? !contactNumber.equals(patient.contactNumber) : patient.contactNumber != null)
//            return false;
//        if (contactPerson != null ? !contactPerson.equals(patient.contactPerson) : patient.contactPerson != null)
//            return false;
//        if (dateOfBirth != null ? !dateOfBirth.equals(patient.dateOfBirth) : patient.dateOfBirth != null) return false;
//        if (emergencyContactNumber != null ? !emergencyContactNumber.equals(patient.emergencyContactNumber) : patient.emergencyContactNumber != null)
//            return false;
        if (gender != patient.gender) return false;
        if (healthId != null ? !healthId.equals(patient.healthId) : patient.healthId != null) return false;
        //if (height != null ? !height.equals(patient.height) : patient.height != null) return false;
        if (id != null ? !id.equals(patient.id) : patient.id != null) return false;
        if (name != null ? !name.equals(patient.name) : patient.name != null) return false;
        //if (relationship != patient.relationship) return false;
        //if (weight != null ? !weight.equals(patient.weight) : patient.weight != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (healthId != null ? healthId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (careOfAddress != null ? careOfAddress.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (bloodType != null ? bloodType.hashCode() : 0);
        // result = 31 * result + (height != null ? height.hashCode() : 0);
        //result = 31 * result + (weight != null ? weight.hashCode() : 0);
        //result = 31 * result + (contactNumber != null ? contactNumber.hashCode() : 0);
        //result = 31 * result + (contactPerson != null ? contactPerson.hashCode() : 0);
        // result = 31 * result + (relationship != null ? relationship.hashCode() : 0);
        //result = 31 * result + (emergencyContactNumber != null ? emergencyContactNumber.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    public Boolean getBirthdateEstimated() {
        return birthdateEstimated;
    }

    public void setBirthdateEstimated(Boolean birthdateEstimated) {
        this.birthdateEstimated = birthdateEstimated;
    }

    public Integer getAgeEstimated() {
        return ageEstimated;
    }

    public void setAgeEstimated(Integer ageEstimated) {
        this.ageEstimated = ageEstimated;
    }

    public Set<Register> getRegisters() {
        return registers;
    }

    public void setRegisters(Set<Register> registers) {
        this.registers = registers;
    }
}
