package org.jugbd.mnet.security;

import org.jugbd.mnet.domain.User;
import org.jugbd.mnet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * @author Bazlur Rahman Rokon
 * @since 9/30/14.
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<User> {

    @Autowired
    private UserService userService;

    @Override
    public User getCurrentAuditor() {

        return userService.getCurrentLoggedInUser();
    }
    
}
