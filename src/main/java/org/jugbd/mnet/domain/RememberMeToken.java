package org.jugbd.mnet.domain;

import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by bazlur on 7/7/14.
 */
@Entity
public class RememberMeToken {
    @Id
    private String series;
    private String username;
    private String token;
    private Date lastUsedDate;

    public RememberMeToken(PersistentRememberMeToken rememberMeToken) {
        this.series = rememberMeToken.getSeries();
        this.username = rememberMeToken.getUsername();
        this.token = rememberMeToken.getTokenValue();
        this.lastUsedDate = rememberMeToken.getDate();
    }

    public RememberMeToken() {
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLastUsedDate() {
        return lastUsedDate;
    }

    public void setLastUsedDate(Date lastUsedDate) {
        this.lastUsedDate = lastUsedDate;
    }
}
