package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

/**
 * Created by bazlur on 7/3/14.
 */
@Component
public interface UserService extends UserDetailsService {
    void save(User user);

    User findByUserName(String username);

    Page<User> findAll(Pageable pageable);

    User findById(Long id);

    User getCurrentLoggedInUser();

    Long count();
}
