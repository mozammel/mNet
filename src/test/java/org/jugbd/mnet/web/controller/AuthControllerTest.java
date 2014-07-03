package org.jugbd.mnet.web.controller;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/servlet-context.xml")
public class AuthControllerTest {
    @Autowired
    protected WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }


    @Test
    public void test_shouldReturnLoginPage() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name(Matchers.containsString("login")));
    }

    @Test
    public void test_shouldReturnLoginErrorPage_And_haveErrorAttribute() throws Exception {
        this.mockMvc.perform(get("/login-error"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(model().attribute("loginError", true))
                .andExpect(view().name(Matchers.containsString("login")));
    }
}