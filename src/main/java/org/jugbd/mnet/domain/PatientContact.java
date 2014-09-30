package org.jugbd.mnet.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.jugbd.mnet.domain.enums.Relationship;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by A N M Bazlur Rahman
 *
 * @since 9/21/14.
 */
@Embeddable
public class PatientContact implements Serializable {

    @NotEmpty
    @Size(max = 100)
    @Column(length = 100)
    private String contactPerson;

    @NotNull
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Relationship relationship;

    @NotEmpty
    @Size(max = 32)
    @Column(length = 32)
    private String emergencyContactNumber;

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
}
