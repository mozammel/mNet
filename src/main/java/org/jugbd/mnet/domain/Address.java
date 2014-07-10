package org.jugbd.mnet.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Raqibul Islam on 7/1/14.
 */
@Embeddable
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 64)
    @Column(length = 64)
    private String houseNameOrNumber;

    @Size(max = 32)
    @Column(length = 32)
    private String road;

    @Size(max = 32)
    @Column(length = 32)
    private String city;

    @Size(max = 32)
    @Column(length = 32)
    private String policeStation;

    @Size(max = 32)
    @Column(length = 32)
    private String postOffice;

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouseNameOrNumber() {
        return houseNameOrNumber;
    }

    public void setHouseNameOrNumber(String houseNameOrNumber) {
        this.houseNameOrNumber = houseNameOrNumber;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
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
}
