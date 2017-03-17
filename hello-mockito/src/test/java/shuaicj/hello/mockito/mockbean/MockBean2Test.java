package shuaicj.hello.mockito.mockbean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Test the spring annotation @MockBean.
 *
 * Mock beans are prior to the same type bean defined in configuration.
 *
 * @author shuaicj 2017/03/17
 */
@RunWith(SpringRunner.class)
public class MockBean2Test {

    @MockBean
    List list; // if replacing @MockBean with @Autowired, the tests will not pass.

    @Test
    public void testGetDefault() throws Exception {
        assertThat(list.get(0)).isNull();
    }

    @Test
    public void testGet1() throws Exception {
        assertThat(list.get(0)).isNull();
        when(list.get(0)).thenReturn("abc");
        assertThat(list.get(0)).isEqualTo("abc");
    }

    @Test
    public void testGet2() throws Exception {
        assertThat(list.get(0)).isNull();
        when(list.get(0)).thenReturn("def");
        assertThat(list.get(0)).isEqualTo("def");
    }

    @Configuration
    static class Config {

        @Bean
        List list() {
            return Arrays.asList("111", "222");
        }
    }
}
