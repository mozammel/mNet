package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Bazlur Rahman Rokon on 7/3/14.
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.username = (:username)")
    User findByUsername(String username);
}
