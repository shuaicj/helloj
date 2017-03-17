package shuaicj.hello.mockito.spybean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

/**
 * Test the spring annotation @SpyBean.
 *
 * Without @SpyBean, we can still spy an object and return as bean.
 *
 * @author shuaicj 2017/03/17
 */
@RunWith(SpringRunner.class)
public class SpyBean2Test {

    @Autowired
    List list;

    @Test
    public void testGetDefault() throws Exception {
        assertThat(list.get(0)).isEqualTo("111");
        assertThat(list.get(1)).isEqualTo("def");
    }

    @Configuration
    static class Config {

        @Bean
        List list() {
            List<String> list = new ArrayList<>();
            list.add("111");
            list = spy(list);
            doReturn("def").when(list).get(1);
            return list;
        }
    }
}
