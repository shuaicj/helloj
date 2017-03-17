package shuaicj.hello.mockito.spybean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

/**
 * Test the spring annotation @SpyBean.
 *
 * Spy beans will reset after each test method.
 *
 * @author shuaicj 2017/03/17
 */
@RunWith(SpringRunner.class)
public class SpyBean1Test {

    @SpyBean
    List list;

    @Test
    public void testGetDefault() throws Exception {
        assertThat(list.get(0)).isEqualTo("111");
        assertThat(list.get(1)).isEqualTo("222");
    }

    @Test
    public void testGet1() throws Exception {
        assertThat(list.get(0)).isEqualTo("111");
        assertThat(list.get(1)).isEqualTo("222");
        doReturn("abc").when(list).get(0);
        assertThat(list.get(0)).isEqualTo("abc");
        assertThat(list.get(1)).isEqualTo("222");
    }

    @Test
    public void testGet2() throws Exception {
        assertThat(list.get(0)).isEqualTo("111");
        assertThat(list.get(1)).isEqualTo("222");
        doReturn("def").when(list).get(0);
        assertThat(list.get(0)).isEqualTo("def");
        assertThat(list.get(1)).isEqualTo("222");
    }

    @Configuration
    static class Config {

        @Bean
        List list() {
            List<String> list = new ArrayList<>();
            list.add("111");
            list.add("222");
            return list;
        }
    }
}
