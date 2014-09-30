package org.jugbd.mnet.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Raqibul Islam on 7/1/14.
 */
@Embeddable
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 256)
    @Column(length = 256)
    @NotNull
    private String homeAddress;

    @Size(max = 32)
    @Column(length = 32)
    @NotNull
    private String policeStation;

    @Size(max = 32)
    @Column(length = 32)
    @NotNull
    private String postOffice;

    @Size(max = 32)
    @Column(length = 32)
    @NotNull
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
}
