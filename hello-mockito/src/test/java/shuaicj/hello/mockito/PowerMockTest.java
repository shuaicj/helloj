package shuaicj.hello.mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test the library powermock.
 *
 * @author shuaicj 2018/10/30
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(User.class)
public class PowerMockTest {

    @Test
    public void testCtorWithNoArgs() throws Exception {
        User u = mock(User.class);
        when(u.getName()).thenReturn("aa");
        whenNew(User.class).withNoArguments().thenReturn(u);
        assertThat(new User().getName()).isEqualTo("aa");
    }

    @Test
    public void testCtorWithArgs() throws Exception {
        User u = mock(User.class);
        when(u.getName()).thenReturn("bb");
        whenNew(User.class).withArguments(anyString()).thenReturn(u);
        assertThat(new User("cc").getName()).isEqualTo("bb");
    }

    @Test
    public void testFinalMethod() {
        User u = mock(User.class);
        when(u.getName()).thenReturn("dd");
        assertThat(u.getName()).isEqualTo("dd");
    }

    @Test
    public void testStaticMethod() {
        mockStatic(User.class);
        when(User.getNameStatic(anyString())).thenReturn("ee");
        assertThat(User.getNameStatic("ff")).isEqualTo("ee");
    }

    @Test
    public void testPrivateMethod() throws Exception {
        User u = spy(new User());
        when(u, "getNamePrivate").thenReturn("ii");
        assertThat(u.getNamePrivateProxy()).isEqualTo("ii");
    }
}
