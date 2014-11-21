package org.jugbd.mnet.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.jugbd.mnet.domain.enums.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
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
public class Patient extends PersistentObject {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @Size(max = 32)
    @Column(length = 32)
    private String healthId;

    @NotEmpty
    @Size(max = 100)
    @Column(length = 100)
    private String name;

    @Past
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    @Max(150)
    @Transient
    private Integer age;

    @NotNull
    @Column(length = 6)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 16)
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    @NotEmpty
    @Size(max = 32)
    @Column(length = 32)
    private String contactNumber;

    @Valid
    @Embedded
    private Address address;

    private Boolean dead = false;

    @Temporal(TemporalType.DATE)
    private Date deathDate;

    @Column(length = 12)
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Occupation occupation;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel;

    @Transient
    private Integer ageEstimated;
    private Boolean birthdateEstimated = false;

    @OneToMany(mappedBy = "patient")
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Valid
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
     * @param age       (the age to set)
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

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }
}
