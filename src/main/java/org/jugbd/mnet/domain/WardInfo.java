package org.jugbd.mnet.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Raqibul Islam on 7/1/14.
 */
@Entity
@Table(name = "ward_info")
public class WardInfo extends Persistence {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(max = 32)
    @Column(length = 32)
    private String name;

    @OneToMany(mappedBy = "wardInfo")
    private Set<AdmissionInfo> admissionInfoSet = new HashSet<AdmissionInfo>();

    public WardInfo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AdmissionInfo> getAdmissionInfoSet() {
        return admissionInfoSet;
    }

    public void setAdmissionInfoSet(Set<AdmissionInfo> admissionInfoSet) {
        this.admissionInfoSet = admissionInfoSet;
    }
}
