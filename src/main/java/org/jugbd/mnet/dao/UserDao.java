package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by Bazlur Rahman Rokon on 7/3/14.
 */
@Component
public interface UserDao extends GenericDao<User, Long> {
    User findByUsername(String username);
}
