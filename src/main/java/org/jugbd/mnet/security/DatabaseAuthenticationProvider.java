package org.jugbd.mnet.security;

import org.jugbd.mnet.domain.User;
import org.jugbd.mnet.domain.enums.Role;
import org.jugbd.mnet.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * Created by bazlur on 7/3/14.
 */
@Service("databaseAuthenticationProvider")
public class DatabaseAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private MessageDigestPasswordEncoder messageDigestPasswordEncoder;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        //ignored
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        logger.debug("retrieveUser()  username ={}", username);

        String password = (String) authentication.getCredentials();
        if (!StringUtils.hasText(password)) {
            throw new BadCredentialsException("Please enter password");
        }

        try {
            User targetUser = (User) userService.loadUserByUsername(username);
            String encryptedPassword = messageDigestPasswordEncoder.encodePassword(password, targetUser.getSalt());
            String expectedPassword = targetUser.getHashedPassword();

            if (!StringUtils.hasText(expectedPassword)) {
                throw new BadCredentialsException("No password for "
                        + username
                        + " set in database, contact administrator");
            }

            if (!encryptedPassword.equals(expectedPassword)) {
                throw new BadCredentialsException("Invalid Password");
            }

            return targetUser;

        } catch (Exception ex) {
            throw new BadCredentialsException("Invalid user");
        }
    }
}
