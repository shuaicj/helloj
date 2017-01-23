package shuaicj.hello.mockito;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
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
        List list = mock(List.class);
        when(list.get(0)).thenReturn("abc");
        assertThat(list.get(0)).isEqualTo("abc");
    }

    @Test
    public void testStubDefault() throws Exception {
        List list = mock(List.class);
        assertThat(list.get(0)).isNull();
    }

    @Test
    public void testStubRepeat() throws Exception {
        List list = mock(List.class);
        when(list.get(0)).thenReturn("abc").thenReturn("def");
        assertThat(list.get(0)).isEqualTo("abc");
        assertThat(list.get(0)).isEqualTo("def");

        when(list.get(1)).thenReturn("111", "222");
        assertThat(list.get(1)).isEqualTo("111");
        assertThat(list.get(1)).isEqualTo("222");

        // incorrect usage! The last one will override the previous ones
        when(list.get(2)).thenReturn("###");
        when(list.get(2)).thenReturn("$$$");
        assertThat(list.get(2)).isEqualTo("$$$");
        assertThat(list.get(2)).isEqualTo("$$$");
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testVerify() throws Exception {
        List list = mock(List.class);
        list.add("one");
        list.add("two");
        list.clear();
        verify(list).add("one");
        verify(list).add("two");
        verify(list).clear();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    @SuppressWarnings("unchecked")
    public void testExceptionClass() throws Exception {
        List list = mock(List.class);
        when(list.get(1)).thenThrow(IndexOutOfBoundsException.class);
        list.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testExceptionNew() throws Exception {
        List list = mock(List.class);
        when(list.get(1)).thenThrow(new IndexOutOfBoundsException());
        list.get(1);
    }

    @Test
    public void testAnyInt() throws Exception {
        List list = mock(List.class);
        when(list.get(anyInt())).thenReturn("abc");
        assertThat(list.get(0)).isEqualTo("abc");
        assertThat(list.get(2)).isEqualTo("abc");
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testAnyString() throws Exception {
        List list = mock(List.class);
        when(list.add(anyString())).thenReturn(true);
        assertThat(list.add("abc")).isTrue();
        assertThat(list.add("abc")).isTrue();
    }

    @Test
    @SuppressWarnings({"unchecked", "Convert2Lambda"})
    public void testAnswer() throws Exception {
        List<String> list = mock(List.class);
        when(list.get(anyInt())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
                int index = invocationOnMock.getArgumentAt(0, Integer.class);
                return index <= 1 ? "abc" : "def";
            }
        });
        assertThat(list.get(0)).isEqualTo("abc");
        assertThat(list.get(1)).isEqualTo("abc");
        assertThat(list.get(2)).isEqualTo("def");
        assertThat(list.get(3)).isEqualTo("def");
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testAnswerLamda() throws Exception {
        List<String> list = mock(List.class);
        when(list.get(anyInt())).thenAnswer(invocationOnMock -> {
            int index = invocationOnMock.getArgumentAt(0, Integer.class);
            return index <= 1 ? "abc" : "def";
        });
        assertThat(list.get(0)).isEqualTo("abc");
        assertThat(list.get(1)).isEqualTo("abc");
        assertThat(list.get(2)).isEqualTo("def");
        assertThat(list.get(3)).isEqualTo("def");
    }

    @Test(expected = RuntimeException.class)
    public void testVoidMethod() throws Exception {
        List list = mock(List.class);

        doReturn(true).when(list).isEmpty();
        assertThat(list.isEmpty()).isTrue();

        doThrow(new RuntimeException()).when(list).clear();
        list.clear();
    }

    @Test
    public void testSpy() throws Exception {
        List list = spy(new ArrayList());
        doReturn("abc").when(list).get(0);
        assertThat(list.get(0)).isEqualTo("abc");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSpyWrongUsage() throws Exception {
        List list = spy(new ArrayList());
        when(list.get(0)).thenReturn("abc");
        list.get(0);
    }
}
