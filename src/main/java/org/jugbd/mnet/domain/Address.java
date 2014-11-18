package org.jugbd.mnet.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.jugbd.mnet.domain.enums.District;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Raqibul Islam on 7/1/14.
 */
@Embeddable
public class Address {

    @Size(max = 256)
    @Column(length = 256)
    @NotEmpty
    private String homeAddress;

    @Size(max = 32)
    @Column(length = 32)
    @NotEmpty
    private String policeStation;

    @Size(max = 32)
    @Column(length = 32)
    @NotEmpty
    private String postOffice;

    @NotNull
    @Column(length = 32)
    @Enumerated(EnumType.STRING)
    private District district;

    @Size(max = 32)
    @Column(length = 32)
    @NotEmpty
    private String division;

    public Address() {
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPoliceStation() {
        return policeStation;
    }

    public void setPoliceStation(String policeStation) {
        this.policeStation = policeStation;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
