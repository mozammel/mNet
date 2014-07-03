package org.jugbd.mnet.web.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpSession;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by bazlur on 7/3/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/applicationContext-security.xml",
        "classpath:applicationContext-jpa.xml"})
public class AccessControlTest {

    private static String SEC_CONTEXT_ATTR = HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
                .addFilters(this.springSecurityFilterChain)
                .build();
    }

    @Test
    public void test_shouldReturn4xxClientError() throws Exception {
        this.mockMvc.perform(get("/hello"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void test_shouldAuthenticateWithUserAdmin() throws Exception {
        final String username = "admin";
        final String password = "admin";
        mockMvc.perform(
                post("/j_spring_security_check").param("username",
                        username).param("password", password))
                .andExpect(redirectedUrl("/admin/index"))
                .andExpect(new ResultMatcher() {
                    public void match(MvcResult mvcResult) throws Exception {
                        HttpSession session = mvcResult.getRequest()
                                .getSession();
                        SecurityContext securityContext = (SecurityContext) session
                                .getAttribute(SEC_CONTEXT_ATTR);
                        assertEquals(securityContext.getAuthentication()
                                .getName(), username);
                    }
                });
    }

    @Test
    public void test_shouldAuthenticateFails() throws Exception {
        final String username = "user";
        mockMvc.perform(
                post("/j_spring_security_check").param("username",
                        username).param("password", "invalid"))
                .andExpect(redirectedUrl("/login-error"))
                .andExpect(new ResultMatcher() {
                    public void match(MvcResult mvcResult) throws Exception {
                        HttpSession session = mvcResult.getRequest()
                                .getSession();
                        SecurityContext securityContext = (SecurityContext) session
                                .getAttribute(SEC_CONTEXT_ATTR);
                        assertNull(securityContext);
                    }
                });
    }


    @Test
    public void test_shouldRedirectToLoginUrl() throws Exception {
        mockMvc.perform(get("/")).andExpect(redirectedUrl("http://localhost/login"));
    }
}
