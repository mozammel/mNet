package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.UserDao;
import org.jugbd.mnet.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by bazlur on 7/3/14.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void create(User user) {
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
        return userDao.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userDao.findOne(id);
    }
}
