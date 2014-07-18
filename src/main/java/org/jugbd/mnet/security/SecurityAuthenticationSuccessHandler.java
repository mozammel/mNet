package org.jugbd.mnet.security;

import org.jugbd.mnet.domain.enums.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * Created by bazlur on 7/3/14.
 */
public class SecurityAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private static final Logger log = LoggerFactory.getLogger(SecurityAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.debug("nAuthenticationSuccess()");

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if (roles.contains(Role.ROLE_ADMIN.name())) {
            log.debug("role admin found, redirecting to intake page");
            response.sendRedirect("/admin/index");
        } else if (roles.contains(Role.ROLE_USER.name())) {
            log.debug("role user found, redirecting to intake page");
            response.sendRedirect("/patient/search");
        }
    }
}
