package shuaicj.hello.rest.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test Spring Security.
 *
 * @author shuaicj 2017/04/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void unprotected() throws Exception {
        mockMvc.perform(get("/hello")).andExpect(status().isOk());
    }

    @Test
    public void unauthorized() throws Exception {
        mockMvc.perform(get("/me")).andExpect(status().isUnauthorized());
    }

    @Test
    public void auth() throws Exception {
        mockMvc.perform(get("/me").with(httpBasic("shuaicj", "shuaicj")))
                .andExpect(status().isOk()).andExpect(authenticated());
    }

    @Test
    public void signout() throws Exception {
        mockMvc.perform(logout()).andExpect(status().isFound()).andExpect(unauthenticated());
    }

    @Test
    public void session() throws Exception {
        MvcResult result = mockMvc.perform(get("/me").with(httpBasic("shuaicj", "shuaicj")))
                .andExpect(status().isOk()).andExpect(authenticated()).andReturn();
        MockHttpSession sess = (MockHttpSession) result.getRequest().getSession(false);
        mockMvc.perform(get("/me").session(sess)).andExpect(status().isOk()).andExpect(authenticated());
        mockMvc.perform(post("/logout").with(csrf()).session(sess)).andExpect(unauthenticated());
        mockMvc.perform(get("/me")).andExpect(status().isUnauthorized()).andExpect(unauthenticated());
    }
}