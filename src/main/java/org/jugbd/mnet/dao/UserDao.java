package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Bazlur Rahman Rokon
 * @since 7/3/14.
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
