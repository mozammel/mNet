package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Bazlur Rahman Rokon on 7/3/14.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User findByUsername(String username) {

        Query query = em.createNamedQuery("findByUseranme");
        query.setParameter("username", username);
        return (User) query.getSingleResult();
    }

    @Override
    public void createNewUser(User user) {
        em.persist(user);
    }

    @Override
    public List<User> findAllUsers() {
        return em.createNamedQuery("findAllUsers", User.class).getResultList();
    }
}
