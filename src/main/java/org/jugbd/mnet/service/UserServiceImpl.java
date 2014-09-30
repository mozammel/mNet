package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.UserDao;
import org.jugbd.mnet.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;

/**
 * Created by bazlur on 7/3/14.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private MessageDigestPasswordEncoder messageDigestPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(messageDigestPasswordEncoder.encodePassword(user.getPassword(), null));
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        userDao.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found by " + username);
        }

        return user;
    }

    @Override
    public User findByUserName(String username) {
        try {

            return userDao.findByUsername(username);
        } catch (NoResultException e) {
            log.error("user not found by ={}", username, e);
        }

        return null;
    }

    @Override
    public User findById(Long id) {

        return userDao.findOne(id);
    }

    @Override
    public User getCurrentLoggedInUser() {
        log.debug("getCurrentLoggedInUser()");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.debug("authentication.getName() ={}", authentication.getName());

        return findByUserName(authentication.getName());
    }

    @Override
    public List<User> findAll() {

        return userDao.findAll();
    }
}
