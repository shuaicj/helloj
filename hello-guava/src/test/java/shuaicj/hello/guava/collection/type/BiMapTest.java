package shuaicj.hello.guava.collection.type;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;

/**
 * Test BiMap.
 *
 * @author shuaicj 2017/12/27
 */
public class BiMapTest {

    @Test
    public void inverse() {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("k1", "v1");
        biMap.put("k2", "v2");
        biMap.put("k3", "v3");

        assertThat(biMap).containsOnly(entry("k1", "v1"), entry("k2", "v2"), entry("k3", "v3"));
        assertThat(biMap.inverse()).containsOnly(entry("v1", "k1"), entry("v2", "k2"), entry("v3", "k3"));

        biMap.inverse().put("v4", "k4");

        assertThat(biMap).containsOnly(entry("k1", "v1"), entry("k2", "v2"), entry("k3", "v3"), entry("k4", "v4"));
        assertThat(biMap.inverse()).containsOnly(entry("v1", "k1"), entry("v2", "k2"), entry("v3", "k3"), entry("v4", "k4"));
    }

    @Test
    public void put() {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("k1", "v1");
        biMap.put("k1", "v2");
        assertThat(biMap).containsOnly(entry("k1", "v2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueExists() {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("k1", "v1");
        biMap.put("k2", "v1");
    }

    @Test
    public void forcePut() {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("k1", "v1");
        biMap.forcePut("k2", "v1");
        assertThat(biMap).containsOnly(entry("k2", "v1"));
    }
}
