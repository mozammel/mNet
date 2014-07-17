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
    void save(User user);

    User findByUserName(String username);

    List<User> findAll();

    User findById(Long id);
}
