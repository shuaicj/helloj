package shuaicj.hello.guava.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import com.google.common.io.CharStreams;
import org.junit.Test;

/**
 * Test CharStreams.
 *
 * @author shuaicj 2018/01/03
 */
public class CharStreamsTest {

    @Test
    public void string() throws IOException {
        StringReader r = new StringReader("abcd");
        assertThat(CharStreams.toString(r)).isEqualTo("abcd");
    }

    @Test
    public void readLines() throws IOException {
        StringReader r = new StringReader("abcd\naa\ncc");
        assertThat(CharStreams.readLines(r)).containsExactly("abcd", "aa", "cc");
    }

    @Test
    public void copy() throws IOException {
        StringReader r = new StringReader("abcd");
        StringWriter w = new StringWriter();
        assertThat(CharStreams.copy(r, w)).isEqualTo(4);
        assertThat(w.toString()).isEqualTo("abcd");
    }
}
