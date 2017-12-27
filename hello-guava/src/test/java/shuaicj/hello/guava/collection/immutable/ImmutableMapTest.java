package shuaicj.hello.guava.collection.immutable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.entry;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

/**
 * Test ImmutableMap.
 *
 * @author shuaicj 2017/12/27
 */
public class ImmutableMapTest {

    @Test
    @SuppressWarnings("deprecation")
    public void immutable() {
        ImmutableMap<String, String> map = ImmutableMap.of("k1", "v1", "k2", "v2");
        assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> map.put("k3", "v3"));
    }

    @Test
    public void test() {
        ImmutableMap<String, String> map = ImmutableMap.of("k1", "v1", "k2", "v2");
        assertThat(map).containsOnly(entry("k1", "v1"), entry("k2", "v2"));
    }
}
