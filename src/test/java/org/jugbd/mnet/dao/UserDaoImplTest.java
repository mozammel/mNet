package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.User;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/servlet-context.xml", "classpath:applicationContext-jpa.xml"})
@Transactional
public class UserDaoImplTest {
    private static final Logger log = LoggerFactory.getLogger(UserDaoImplTest.class);

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UserDao userDao;

    @After
    public void tearDown() throws Exception {
        em.createQuery("delete from User").executeUpdate();
    }

    @Test
    public void testUserDaoNotNull() {
        assertNotNull(userDao);
    }

    @Test
    public void testFindByUsername() throws Exception {
        User user = createUser("rokon", "1235");
        userDao.createNewUser(user);
        assertNotNull(userDao.findByUsername("rokon"));
    }

    @Test
    public void testCreateNewUser() throws Exception {
        User user = new User("bazlur", "4514");
        userDao.createNewUser(user);

        deleteUser(user);
    }

    @Test
    public void testFindAllUsers() throws Exception {
        createUser("rokon", "1235");
        createUser("rokon1", "1235");
        createUser("rokon12", "1235");
        assertEquals(3, userDao.findAllUsers().size());
    }

    private User createUser(String username, String password) {
        User user = new User(username, password);
        em.persist(user);
        return user;
    }

    private void deleteUser(User user) {
        em.detach(user);
    }
}