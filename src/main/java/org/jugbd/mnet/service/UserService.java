package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by bazlur on 7/3/14.
 */
@Component
public interface UserService extends UserDetailsService {
    public void save(User user);

    public User findByUserName(String username);

    public User findById(Long id);

    public List<User> findAll();

}
