package shuaicj.hello.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test HelloController via RestTemplate.
 *
 * @author shuaicj 2016/12/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerClientTest {

    @Autowired
    private TestRestTemplate rest;

    @Test
    public void hello() throws Exception {
        Hello h = rest.getForObject("/hello", Hello.class);
        assertThat(h.getId()).isEqualTo(1L);
        assertThat(h.getContent()).isEqualTo("Hello World!");
    }

    @Test
    public void helloMe() throws Exception {
        Hello h = rest.getForObject("/hello?name=Me", Hello.class);
        assertThat(h.getId()).isEqualTo(2L);
        assertThat(h.getContent()).isEqualTo("Hello Me!");
    }

}