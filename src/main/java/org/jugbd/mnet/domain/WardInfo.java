package org.jugbd.mnet.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author raqibul
 * @since 7/1/14 2:27 PM
 */
@Entity
@Table(name = "ward_info")
public class WardInfo {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(max = 32)
    @Column(length = 32)
    private String name;

    @OneToMany(mappedBy = "wardInfo")
    private List<AdmissionInfo> admissionInfoList;

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

    public List<AdmissionInfo> getAdmissionInfoList() {
        return admissionInfoList;
    }

    public void setAdmissionInfoList(List<AdmissionInfo> admissionInfoList) {
        this.admissionInfoList = admissionInfoList;
    }
}
