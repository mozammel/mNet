package org.jugbd.mnet.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Raqibul Islam on 7/1/14.
 */
@Entity
@Table(name = "admission_info")
public class AdmissionInfo extends Persistence {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @NotNull
    private Date admissionDate;

    @NotNull
    private Date injuryDate;

    @NotEmpty
    @Size(max = 32)
    @Column(length = 32)
    private String bedNumber;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "admissionInfo", cascade = CascadeType.ALL)
    @Column(nullable = false)
    private Set<Diagnosis> diagnoses = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "ward_info_id")
    private WardInfo wardInfo;

    public AdmissionInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getInjuryDate() {
        return injuryDate;
    }

    public void setInjuryDate(Date injuryDate) {
        this.injuryDate = injuryDate;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public Set<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public WardInfo getWardInfo() {
        return wardInfo;
    }

    public void setWardInfo(WardInfo wardInfo) {
        this.wardInfo = wardInfo;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AdmissionInfo that = (AdmissionInfo) o;

        if (admissionDate != null ? !admissionDate.equals(that.admissionDate) : that.admissionDate != null)
            return false;
        if (bedNumber != null ? !bedNumber.equals(that.bedNumber) : that.bedNumber != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (injuryDate != null ? !injuryDate.equals(that.injuryDate) : that.injuryDate != null) return false;
        if (patient != null ? !patient.equals(that.patient) : that.patient != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (wardInfo != null ? !wardInfo.equals(that.wardInfo) : that.wardInfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (admissionDate != null ? admissionDate.hashCode() : 0);
        result = 31 * result + (injuryDate != null ? injuryDate.hashCode() : 0);
        result = 31 * result + (bedNumber != null ? bedNumber.hashCode() : 0);
        result = 31 * result + (patient != null ? patient.hashCode() : 0);
        result = 31 * result + (wardInfo != null ? wardInfo.hashCode() : 0);
        return result;
    }
}
