package shuaicj.hello.mockito.mockbean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test the spring annotation @MockBean.
 *
 * Without MockBean, we can still mock an object and return as bean.
 *
 * @author shuaicj 2017/03/17
 */
@RunWith(SpringRunner.class)
public class MockBean3Test {

    @Autowired
    List list;

    @Test
    public void testGetDefault() throws Exception {
        assertThat(list.get(0)).isEqualTo("111");
    }

    @Configuration
    static class Config {

        @Bean
        List list() {
            List list = mock(List.class);
            when(list.get(0)).thenReturn("111");
            return list;
        }
    }
}
