package shuaicj.hello.mockito;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Test the library mockito.
 *
 * @author shuaicj 2017/01/22
 */
public class MockitoTest {

    @Test
    public void testStub() throws Exception {
        List<String> list = mock(List.class);
        when(list.get(0)).thenReturn("abc");
        assertThat(list.get(0)).isEqualTo("abc");
    }

    @Test
    public void testStubDefault() throws Exception {
        List<String> list = mock(List.class);
        assertThat(list.get(0)).isNull();
    }

    @Test
    public void testStubRepeat() throws Exception {
        List<String> list = mock(List.class);
        when(list.get(0)).thenReturn("abc");
        when(list.get(1)).thenReturn("def");
        assertThat(list.get(0)).isEqualTo("abc");
        assertThat(list.get(1)).isEqualTo("def");
    }

    @Test
    public void testVerify() throws Exception {
        List<String> list = mock(List.class);
        list.add("one");
        list.add("two");
        list.clear();
        verify(list).add("one");
        verify(list).add("two");
        verify(list).clear();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testExceptionClass() throws Exception {
        List<String> list = mock(List.class);
        when(list.get(1)).thenThrow(IndexOutOfBoundsException.class);
        list.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testExceptionNew() throws Exception {
        List<String> list = mock(List.class);
        when(list.get(1)).thenThrow(new IndexOutOfBoundsException());
        list.get(1);
    }

    @Test
    public void testAnyInt() throws Exception {
        List<String> list = mock(List.class);
        when(list.get(anyInt())).thenReturn("abc");
        assertThat(list.get(0)).isEqualTo("abc");
        assertThat(list.get(2)).isEqualTo("abc");
    }

    @Test
    public void testAnyString() throws Exception {
        List<String> list = mock(List.class);
        when(list.add(anyString())).thenReturn(true);
        assertThat(list.add("abc")).isTrue();
        assertThat(list.add("abc")).isTrue();
    }
}
