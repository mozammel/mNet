package org.jugbd.mnet.web.controller;

/**
 * Created by Bazlur Rahman Rokon on 7/17/14.
 */
public class PatientSearchCmd {
    private String healthId;
    private String phoneNumber;
    private String name;

    public String getHealthId() {
        return healthId;
    }

    public void setHealthId(String healthId) {
        this.healthId = healthId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PatientSearchCmd{" +
                "healthId='" + healthId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
