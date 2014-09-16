package org.jugbd.mnet.utils;

import org.jugbd.mnet.domain.User;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertNotNull;

public class UtilsTest {

    protected static final String USERNAME = "aName";
    protected static final String PASSWORD = "aPassword";
    protected static final User ADMIN_USER = new User("admin", "admin");

    @Test
    public void testUpdatePersistentProperties() throws Exception {
        User user = new User(USERNAME, PASSWORD);
        Utils.updatePersistentProperties(user, ADMIN_USER);

        assertNotNull(user.getCreatedBy());
        assertNotNull(user.getLastUpdatedBy());
        assertNotNull(user.getCreated());
        assertNotNull(user.getUpdated());
    }

    @Test
    public void testIsNew() throws Exception {
        User user = new User(USERNAME, PASSWORD);
        assertTrue(Utils.isNew(user));

        User user2 = new User(USERNAME, PASSWORD);
        user2.setId((long)1);
        assertTrue(!Utils.isNew(user2));

    }
}