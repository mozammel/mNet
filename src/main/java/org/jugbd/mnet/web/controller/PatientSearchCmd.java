package org.jugbd.mnet.web.controller;

/**
 * Created by Bazlur Rahman Rokon on 7/17/14.
 */
public class PatientSearchCmd {
    private String healthId;
    private String phoneNumber;

    public PatientSearchCmd() {
    }

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
}
