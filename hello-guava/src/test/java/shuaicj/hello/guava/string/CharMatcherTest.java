package shuaicj.hello.guava.string;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.base.CharMatcher;
import org.junit.Test;

/**
 * Test CharMatcher.
 *
 * @author shuaicj 2018/01/02
 */
public class CharMatcherTest {

    @Test
    public void anyOf() {
        assertThat(CharMatcher.anyOf("abc").matchesAllOf("ababcc")).isTrue();
        assertThat(CharMatcher.anyOf("abc").matchesAllOf("ababec")).isFalse();
    }

    @Test
    public void inRange() {
        assertThat(CharMatcher.inRange('0', '9').matchesAllOf("023423")).isTrue();
        assertThat(CharMatcher.inRange('0', '9').matchesAllOf("02a423")).isFalse();
    }

    @Test
    public void or() {
        assertThat(CharMatcher.inRange('0', '9').or(CharMatcher.inRange('a', 'z')).matchesAllOf("b2a423")).isTrue();
        assertThat(CharMatcher.inRange('0', '9').or(CharMatcher.inRange('a', 'z')).matchesAllOf("B2A423")).isFalse();
    }

    @Test
    public void remove() {
        assertThat(CharMatcher.inRange('0', '9').removeFrom("02a4b3")).isEqualTo("ab");
    }

    @Test
    public void retain() {
        assertThat(CharMatcher.inRange('0', '9').retainFrom("02a4b3")).isEqualTo("0243");
    }

    @Test
    public void replace() {
        assertThat(CharMatcher.inRange('0', '9').replaceFrom("02a4b3", '-')).isEqualTo("--a-b-");
    }

    @Test
    public void trim() {
        assertThat(CharMatcher.inRange('0', '9').trimFrom("02a4b3")).isEqualTo("a4b");
    }
}
