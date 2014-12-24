package org.jugbd.mnet.domain;

import org.jugbd.mnet.domain.enums.Relationship;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by A N M Bazlur Rahman
 *
 * @since 9/21/14.
 */
@Embeddable
public class PatientContact implements Serializable {

    @Size(max = 100)
    @Column(length = 100)
    private String contactPerson;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Relationship relationship;

    private String comments;

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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
