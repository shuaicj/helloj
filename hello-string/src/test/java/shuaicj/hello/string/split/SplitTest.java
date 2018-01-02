package shuaicj.hello.string.split;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * Test String.spit().
 *
 * String.split() will skip the trailing whitespace, which is weired. See JDK Javadoc.
 * Consider use <a href="https://github.com/google/guava/wiki/StringsExplained#splitter">Google Guava Splitter</a> instead.
 *
 * @author shuaicj 2018/01/02
 */
public class SplitTest {

    @Test
    public void ok() {
        assertThat("a,b,c".split(",")).containsExactly("a", "b", "c");
    }

    @Test
    public void skipTrailing() {
        assertThat(",a,b,,c,".split(",")).containsExactly("", "a", "b", "", "c");
    }
}
