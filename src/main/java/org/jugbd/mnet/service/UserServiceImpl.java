package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.UserDao;
import org.jugbd.mnet.domain.User;
import org.jugbd.mnet.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

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
        user.setSalt(StringUtils.generateRandomString(8));
        user.setHashedPassword(messageDigestPasswordEncoder.encodePassword(user.getPassword(), user.getSalt()));
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

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.debug("getCurrentLoggedInUser() => user.getUsername() ={}, id={}", user.getUsername(), user.getId());

        return findById(user.getId());
    }

    @Override
    public Page<User> findAll(Pageable pageable) {

        return userDao.findAll(pageable);
    }
}
