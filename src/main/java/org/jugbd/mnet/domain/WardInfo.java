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
    private Long id;

    @Size(max = 100)
    @Column(length = 100)
    private String name;

    @OneToMany(mappedBy = "wardInfo")
    private Set<AdmissionInfo> admissionInfoSet = new HashSet<AdmissionInfo>();

    public WardInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
