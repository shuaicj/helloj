package shuaicj.hello.guava.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.google.common.io.ByteStreams;
import org.junit.Test;

/**
 * Test ByteStreams.
 *
 * @author shuaicj 2018/01/03
 */
public class ByteStreamsTest {

    @Test
    public void toByteArray() throws IOException {
        InputStream in = new ByteArrayInputStream(new byte[]{1, 2, 3, 4});
        assertThat(ByteStreams.toByteArray(in)).containsExactly(1, 2, 3, 4);
    }

    @Test
    public void copy() throws IOException {
        InputStream in = new ByteArrayInputStream(new byte[]{1, 2, 3, 4});
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        assertThat(ByteStreams.copy(in, out)).isEqualTo(4);
        assertThat(out.toByteArray()).containsExactly(1, 2, 3, 4);
    }
}
