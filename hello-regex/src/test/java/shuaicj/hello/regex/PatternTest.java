package shuaicj.hello.regex;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Pattern;

import org.junit.Test;

/**
 * Test Pattern.
 *
 * @author shuaicj 2018/03/02
 */
public class PatternTest {

    // pattern for JWT token, Base64URL encoding
    private static final Pattern pattern = Pattern.compile("[A-Za-z0-9_-]+\\.[A-Za-z0-9_-]+\\.[A-Za-z0-9_-]+");

    @Test
    public void test() {
        assertThat(pattern.matcher("ABCad9.gvA4.23Ad").matches()).isTrue();
        assertThat(pattern.matcher("ABCav9_.av-A4.-23Ad").matches()).isTrue();
        assertThat(pattern.matcher("ABCa+v9.avA4.23Ad").matches()).isFalse();
        assertThat(pattern.matcher("ABCav9.av/A4.23Ad").matches()).isFalse();
        assertThat(pattern.matcher("ABCav9.avA4.23Ad=").matches()).isFalse();
        assertThat(pattern.matcher("ABCad9.gvA4").matches()).isFalse();
        assertThat(pattern.matcher("ABCad9..23Ad").matches()).isFalse();
        assertThat(pattern.matcher(".gvA4.23Ad").matches()).isFalse();
    }
}
