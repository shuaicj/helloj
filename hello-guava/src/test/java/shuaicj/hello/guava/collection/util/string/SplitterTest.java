package shuaicj.hello.guava.collection.util.string;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.base.Splitter;
import org.junit.Test;

/**
 * Test Splitter.
 *
 * @author shuaicj 2018/01/02
 */
public class SplitterTest {

    @Test
    public void onChar() {
        assertThat(Splitter.on('|').split("a|b|c")).containsExactly("a", "b", "c");
    }

    @Test
    public void onString() {
        assertThat(Splitter.on(", ").split("a, b, c")).containsExactly("a", "b", "c");
    }

    @Test
    public void omitEmpty() {
        assertThat(Splitter.on('|').split("a||c")).containsExactly("a", "", "c");
        assertThat(Splitter.on('|').omitEmptyStrings().split("a||c")).containsExactly("a", "c");
    }

    @Test
    public void trim() {
        assertThat(Splitter.on('|').split("|a||c|")).containsExactly("", "a", "", "c", "");
        assertThat(Splitter.on('|').trimResults().split("a||c")).containsExactly("a", "", "c");
    }

    @Test
    public void limit() {
        assertThat(Splitter.on('|').limit(2).split("a|b|c")).containsExactly("a", "b|c");
    }
}
