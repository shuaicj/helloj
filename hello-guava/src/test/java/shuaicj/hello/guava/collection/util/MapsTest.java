package shuaicj.hello.guava.collection.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.junit.Test;

/**
 * Test Maps.
 *
 * @author shuaicj 2017/12/27
 */
public class MapsTest {

    @Test
    public void difference() {
        Map<String, String> map1 = ImmutableMap.of("k1", "v1", "k2", "v2");
        Map<String, String> map2 = ImmutableMap.of("k2", "v2", "k3", "v3");
        assertThat(Maps.difference(map1, map2).areEqual()).isFalse();
        assertThat(Maps.difference(map1, map2).entriesInCommon()).containsOnly(entry("k2", "v2"));
        assertThat(Maps.difference(map1, map2).entriesOnlyOnLeft()).containsOnly(entry("k1", "v1"));
        assertThat(Maps.difference(map1, map2).entriesOnlyOnRight()).containsOnly(entry("k3", "v3"));
    }
}
