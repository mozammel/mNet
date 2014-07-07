package org.jugbd.mnet.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author raqibul
 * @since 7/1/14 2:10 PM
 */
@Entity
@Table(name = "address")
public class Address {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(max = 32)
    @Column(length = 32)
    private String houseNumber;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
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
