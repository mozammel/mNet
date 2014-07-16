package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Created by Bazlur Rahman Rokon on 7/3/14.
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

    @Override
    public User findByUsername(String username) throws NoResultException{

        TypedQuery<User> query = entityManager.createNamedQuery("findByUsername", User.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }
}
