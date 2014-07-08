package org.jugbd.mnet.security;

import org.jugbd.mnet.domain.RememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by bazlur on 7/7/14.
 */
@Component
@Transactional
public class RememberMeTokenRepository implements PersistentTokenRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        RememberMeToken rememberMeToken = new RememberMeToken(token);
        em.persist(rememberMeToken);
    }

    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        RememberMeToken token = this.em.find(RememberMeToken.class, series);
        if (token != null) {
            token.setToken(tokenValue);
            token.setLastUsedDate(lastUsed);
            em.persist(token);
        }
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        RememberMeToken token = this.em.find(RememberMeToken.class, seriesId);
        return new PersistentRememberMeToken(token.getUsername(), token.getSeries(), token.getToken(), token.getLastUsedDate());
    }

    @Override
    public void removeUserTokens(String username) {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaDelete<RememberMeToken> delete = cb.createCriteriaDelete(RememberMeToken.class);
        Root e = delete.from(RememberMeToken.class);
        delete.where(cb.equal(e.get("username"), username));
        em.createQuery(delete).executeUpdate();
    }
}
