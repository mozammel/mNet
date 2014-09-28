package org.jugbd.mnet.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Bazlur Rahman Rokon on 8/8/14.
 */
@Entity
public class Visit extends Persistence {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Version
    private Long version;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date visitTime;
    
    @OneToOne(mappedBy = "visit")
    private User visitedBy;
    
    @Column(length = 3000)
    private String comment;

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

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public User getVisitedBy() {
        return visitedBy;
    }

    public void setVisitedBy(User visitedBy) {
        this.visitedBy = visitedBy;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
