package shuaicj.hello.guava.collection.util.string;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.base.CaseFormat;
import org.junit.Test;

/**
 * Test CaseFormat.
 *
 * @author shuaicj 2018/01/02
 */
public class CaseFormatTest {

    @Test
    public void lowerCamel() {
        assertThat(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "HELLO_WORLD")).isEqualTo("helloWorld");
    }

    @Test
    public void lowerHyphen() {
        assertThat(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN, "HELLO_WORLD")).isEqualTo("hello-world");
    }

    @Test
    public void lowerUnderscore() {
        assertThat(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_UNDERSCORE, "HELLO_WORLD")).isEqualTo("hello_world");
    }

    @Test
    public void upperCamel() {
        assertThat(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "HELLO_WORLD")).isEqualTo("HelloWorld");
    }

    @Test
    public void upperUnderscore() {
        assertThat(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_UNDERSCORE, "hello_world")).isEqualTo("HELLO_WORLD");
    }
}
