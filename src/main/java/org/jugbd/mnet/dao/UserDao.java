package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.User;
import org.springframework.stereotype.Component;

/**
 * Created by Bazlur Rahman Rokon on 7/3/14.
 */
@Component
public interface UserDao extends GenericDao<User, Long> {
    User findByUsername(String username);
}
