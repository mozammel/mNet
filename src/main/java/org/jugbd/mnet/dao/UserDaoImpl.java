package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Bazlur Rahman Rokon on 7/3/14.
 */
@Repository
@Transactional
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
    public List findAllUsers() {
        return em.createNamedQuery("findAllUsers").getResultList();
    }
}
