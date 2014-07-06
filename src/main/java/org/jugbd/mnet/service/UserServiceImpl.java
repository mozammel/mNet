package org.jugbd.mnet.service;

import org.jugbd.mnet.dao.UserDao;
import org.jugbd.mnet.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bazlur on 7/3/14.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void create(User user) {

    }
}
