package org.jugbd.mnet.audit;

import org.jugbd.mnet.domain.User;
import org.jugbd.mnet.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Bazlur Rahman Rokon
 * @since 9/30/14.
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<User> {
    private static final Logger log = LoggerFactory.getLogger(SpringSecurityAuditorAware.class);

    @Autowired
    private UserService userService;

    @Override
    public User getCurrentAuditor() {
        log.info("getCurrentAuditor()");

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return userService.findById(user.getId());
    }

}
