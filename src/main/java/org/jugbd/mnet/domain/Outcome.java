package org.jugbd.mnet.domain;

import org.jugbd.mnet.domain.enums.Status;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Bazlur Rahman Rokon on 8/4/14.
 */
@Entity
public class Outcome extends Persistence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;
    private String weWant;
    private String weWillKnow;
    private String soThat;
    private String earlyLiteracy;
    private String whoWillHelp;
    private String whereHow;
    private String frequency;
    private Date startDate;
    private String whatWillHappen;

    @Column(length = 6)
    @Enumerated(EnumType.STRING)
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getWeWant() {
        return weWant;
    }

    public void setWeWant(String weWant) {
        this.weWant = weWant;
    }

    public String getWeWillKnow() {
        return weWillKnow;
    }

    public void setWeWillKnow(String weWillKnow) {
        this.weWillKnow = weWillKnow;
    }

    public String getSoThat() {
        return soThat;
    }

    public void setSoThat(String soThat) {
        this.soThat = soThat;
    }

    public String getEarlyLiteracy() {
        return earlyLiteracy;
    }

    public void setEarlyLiteracy(String earlyLiteracy) {
        this.earlyLiteracy = earlyLiteracy;
    }

    public String getWhoWillHelp() {
        return whoWillHelp;
    }

    public void setWhoWillHelp(String whoWillHelp) {
        this.whoWillHelp = whoWillHelp;
    }

    public String getWhereHow() {
        return whereHow;
    }

    public void setWhereHow(String whereHow) {
        this.whereHow = whereHow;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getWhatWillHappen() {
        return whatWillHappen;
    }

    public void setWhatWillHappen(String whatWillHappen) {
        this.whatWillHappen = whatWillHappen;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
