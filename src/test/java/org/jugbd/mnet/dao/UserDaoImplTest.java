package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/servlet-context.xml",
        "classpath:applicationContext-jpa.xml",
        "file:src/main/webapp/WEB-INF/applicationContext-service.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class UserDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final Logger log = LoggerFactory.getLogger(UserDaoImplTest.class);

    protected static String USER_NAME = "bazlur";
    protected static String PASSWORD = "1234";

    @Autowired
    private UserDao userDao;

    @Test
    public void test_userDaoNotNull() {
        assertNotNull(userDao);
    }

    @Test
    public void test_findByUsername_shouldNotNull() throws Exception {
        User user = createUser(USER_NAME, PASSWORD);
        userDao.save(user);
        assertNotNull(userDao.findByUsername(USER_NAME));
    }

    @Test
    public void whenNewUserIsCreated_thenNoException() throws Exception {
        User user = new User(USER_NAME, PASSWORD);
        userDao.save(user);

        assertNotNull(user.getId());
        assertTrue(user.getId() > 0);

        deleteUser(user);
    }

    @Test
    public void test_whenFindAll_shouldReturnAllUsers() throws Exception {
        createUser(randomAlphabetic(6), randomAlphabetic(6));
        createUser(randomAlphabetic(6), randomAlphabetic(6));
        createUser(randomAlphabetic(6), randomAlphabetic(6));
        assertEquals(3, userDao.findAll().size());

        deleteAll();
    }

    public void test_whenUserIsDeleted_thenNoException() {
        User user = new User(USER_NAME, PASSWORD);
        userDao.save(user);
        Long id = user.getId();

        userDao.delete(id);
        assertNull(userDao.findOne(id));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public final void test_whenEntityWithLongNameIsCreated_thenDataException() {
        userDao.save(new User(randomAlphabetic(2048), PASSWORD));
    }

    private User createUser(String username, String password) {
        User user = new User(username, password);
        userDao.getEntityManager().persist(user);
        return user;
    }

    private void deleteUser(User user) {
        userDao.getEntityManager().detach(user);
    }

    private void deleteAll() {
        userDao.getEntityManager().createQuery("DELETE FROM User").executeUpdate();
    }
}