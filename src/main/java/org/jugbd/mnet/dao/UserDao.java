package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Bazlur Rahman Rokon on 7/3/14.
 */
@Component
public interface UserDao {
    public User findByUsername(String username);

    public void createNewUser(User user);

    public List<User> findAllUsers();
}
