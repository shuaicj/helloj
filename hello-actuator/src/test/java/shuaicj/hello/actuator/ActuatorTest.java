package shuaicj.hello.actuator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test Actuator.
 *
 * @author shuaicj 2017/06/02
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ActuatorTest {

    @Autowired
    private TestRestTemplate rest;

    @Test
    public void test() throws Exception {
        // service
        assertThat(rest.getForEntity("/hello", String.class).getStatusCode()).isEqualTo(HttpStatus.OK);

        // actuator
        assertThat(rest.getForEntity("/health", Map.class).getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(rest.getForEntity("/info", Map.class).getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
