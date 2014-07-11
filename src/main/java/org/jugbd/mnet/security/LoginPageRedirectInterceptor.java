package org.jugbd.mnet.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Bazlur Rahman Rokon on 7/12/14.
 */
public class LoginPageRedirectInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(LoginPageRedirectInterceptor.class);

    private static final String[] LOGIN_PAGE_PREFIXES = new String[]{"/login"};
    private static final String REDIRECT_URL = "/";

    private UrlPathHelper urlPathHelper = new UrlPathHelper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("preHandle()");

        if (isInLoginPaths(this.urlPathHelper.getLookupPathForRequest(request)) && isAuthenticated()) {
            response.setContentType("text/plain");
            sendRedirect(request, response);
            return false;
        } else {
            return true;
        }
    }

    private boolean isAuthenticated() {
        log.debug("isAuthenticated()");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
    }

    private void sendRedirect(HttpServletRequest request, HttpServletResponse response) {
        log.debug("sendRedirect()");
        String encodedRedirectURL = response.encodeRedirectURL(request.getContextPath() + REDIRECT_URL);
        response.setStatus(HttpStatus.TEMPORARY_REDIRECT.value());
        response.setHeader("Location", encodedRedirectURL);
    }

    private boolean isInLoginPaths(final String requestUrl) {
        log.debug("isInLoginPaths() ={}", requestUrl);
        for (String login : LOGIN_PAGE_PREFIXES) {
            if (requestUrl.startsWith(login)) {
                return true;
            }
        }
        return false;
    }
}
