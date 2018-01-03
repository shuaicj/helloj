package shuaicj.hello.guava.string;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

/**
 * Test Joiner.
 *
 * @author shuaicj 2018/01/02
 */
public class JoinerTest {

    @Test
    public void onChar() {
        assertThat(Joiner.on('|').join("a", "b", "c")).isEqualTo("a|b|c");
    }

    @Test
    public void onString() {
        assertThat(Joiner.on(", ").join("a", "b", "c")).isEqualTo("a, b, c");
    }

    @Test(expected = NullPointerException.class)
    public void npe() {
        Joiner.on('|').join("a", null, "c");
    }

    @Test
    public void skipNull() {
        assertThat(Joiner.on('|').skipNulls().join("a", null, "c")).isEqualTo("a|c");
    }

    @Test
    public void replaceNull() {
        assertThat(Joiner.on('|').useForNull("b").join("a", null, "c")).isEqualTo("a|b|c");
    }

    @Test
    public void joinMap() {
        Map<String, String> map = ImmutableMap.of("k1", "v1", "k2", "v2");
        assertThat(Joiner.on('|').withKeyValueSeparator(',').join(map)).isEqualTo("k1,v1|k2,v2");
    }
}
