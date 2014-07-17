package org.jugbd.mnet.security;

import org.jugbd.mnet.domain.enums.Role;
import org.jugbd.mnet.domain.User;
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

    private String adminUser;
    private String adminPassword;

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
        String encryptedPassword = messageDigestPasswordEncoder.encodePassword(password, null);

        String expectedPassword;
        User targetUser;

        if (adminUser.equals(username)) {
            // pseudo-user admin (ie not configured via Person)
            expectedPassword = adminPassword;
            // authenticate admin
            if (!encryptedPassword.equals(expectedPassword)) {
                throw new BadCredentialsException("Invalid password");
            }
            // authorize admin
            targetUser = new User(adminUser, adminPassword);
            targetUser.setRoles(Arrays.asList(Role.ROLE_ADMIN));
        } else {
            try {
                targetUser = (User) userService.loadUserByUsername(username);

                // authenticate the person
                expectedPassword = targetUser.getPassword();
                if (!StringUtils.hasText(expectedPassword)) {
                    throw new BadCredentialsException("No password for "
                            + username
                            + " set in database, contact administrator");
                }
                if (!encryptedPassword.equals(expectedPassword)) {
                    throw new BadCredentialsException("Invalid Password");
                }

            } catch (Exception ex) {
                throw new BadCredentialsException("Invalid user");
            }
        }
        return targetUser;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public void setAdminUser(String adminUser) {
        this.adminUser = adminUser;
    }
}
