package org.jugbd.mnet.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Bazlur Rahman Rokon on 7/3/14.
 */
@MappedSuperclass
public abstract class Persistence implements Serializable {
    private Date dateCreated;

    private Date dateLastUpdated;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private User createdBy;

    @ManyToOne(cascade = CascadeType.MERGE)
    private User lastUpdatedBy;

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(Date dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(User lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}
