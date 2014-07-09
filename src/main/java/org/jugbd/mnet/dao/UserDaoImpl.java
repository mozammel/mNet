package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

/**
 * Created by Bazlur Rahman Rokon on 7/3/14.
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

    @Override
    public User findByUsername(String username)  {

        Query query = getEntityManager().createNamedQuery("findByUsername");
        query.setParameter("username", username);
        return (User) query.getSingleResult();
    }
}
