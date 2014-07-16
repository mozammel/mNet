package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

/**
 * Created by bazlur on 7/3/14.
 */
@Component
public interface UserService extends UserDetailsService {
    void create(User user);

    User findByUserName(String username);

    User findById(Long id);
}
