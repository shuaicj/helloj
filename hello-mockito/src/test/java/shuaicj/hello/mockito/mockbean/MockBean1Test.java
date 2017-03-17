package shuaicj.hello.mockito.mockbean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Test the spring annotation @MockBean.
 *
 * Mock beans will reset after each test method.
 *
 * Strange: Mock list when get(0) returns null instead of throwing IndexOutOfBoundsException.
 *
 * @author shuaicj 2017/03/17
 */
@RunWith(SpringRunner.class)
public class MockBean1Test {

    @MockBean
    List list;

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
}
