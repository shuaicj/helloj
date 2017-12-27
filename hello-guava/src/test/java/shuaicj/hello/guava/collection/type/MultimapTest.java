package shuaicj.hello.guava.collection.type;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.SortedSetMultimap;
import org.junit.Test;

/**
 * Test Multimap.
 *
 * @author shuaicj 2017/12/27
 */
public class MultimapTest {

    @Test
    public void testListMultimap() {
        ListMultimap<String, String> multimap = MultimapBuilder.hashKeys().linkedListValues().build();
        multimap.put("k1", "v11");
        multimap.put("k1", "v12");
        multimap.put("k1", "v13");
        multimap.put("k2", "v2");
        multimap.put("k2", "v2");
        multimap.put("k3", "v3");

        Map<String, Collection<String>> map = multimap.asMap();
        assertThat(map).containsOnlyKeys("k1", "k2", "k3");
        assertThat(map.get("k1")).containsExactly("v11", "v12", "v13");
        assertThat(map.get("k2")).containsExactly("v2", "v2");
        assertThat(map.get("k3")).containsExactly("v3");

        Collection<Map.Entry<String, String>> entries = multimap.entries();
        assertThat(entries).containsExactlyInAnyOrder(
                entry("k1", "v11"),
                entry("k1", "v12"),
                entry("k1", "v13"),
                entry("k2", "v2"),
                entry("k2", "v2"),
                entry("k3", "v3")
        );

        Multiset<String> keys = multimap.keys();
        assertThat(keys).containsExactlyInAnyOrder("k1", "k1", "k1", "k2", "k2", "k3");

        Set<String> keySet = multimap.keySet();
        assertThat(keySet).containsExactlyInAnyOrder("k1", "k2", "k3");

        Collection<String> values = multimap.values();
        assertThat(values).containsExactlyInAnyOrder("v11", "v12", "v13", "v2", "v2", "v3");

        List<String> k1Values = multimap.get("k1");
        assertThat(k1Values).containsExactly("v11", "v12", "v13");
    }

    @Test
    public void testSetMultimap() {
        SetMultimap<String, String> multimap = MultimapBuilder.treeKeys().hashSetValues().build();
        multimap.put("k1", "v11");
        multimap.put("k1", "v12");
        multimap.put("k1", "v13");
        multimap.put("k2", "v2");
        multimap.put("k2", "v2");
        multimap.put("k3", "v3");

        Map<String, Collection<String>> map = multimap.asMap();
        assertThat(map).containsOnlyKeys("k1", "k2", "k3");
        assertThat(map.get("k1")).containsExactlyInAnyOrder("v11", "v12", "v13");
        assertThat(map.get("k2")).containsExactlyInAnyOrder("v2");
        assertThat(map.get("k3")).containsExactlyInAnyOrder("v3");

        Set<Map.Entry<String, String>> entries = multimap.entries();
        assertThat(entries).containsExactlyInAnyOrder(
                entry("k1", "v11"),
                entry("k1", "v12"),
                entry("k1", "v13"),
                entry("k2", "v2"),
                entry("k3", "v3")
        );

        Multiset<String> keys = multimap.keys();
        assertThat(keys).containsExactly("k1", "k1", "k1", "k2", "k3");

        Set<String> keySet = multimap.keySet();
        assertThat(keySet).containsExactly("k1", "k2", "k3");

        Collection<String> values = multimap.values();
        assertThat(values).containsExactlyInAnyOrder("v11", "v12", "v13", "v2", "v3");

        Set<String> k1Values = multimap.get("k1");
        assertThat(k1Values).containsExactlyInAnyOrder("v11", "v12", "v13");
    }

    @Test
    public void testSortedSetMultimap() {
        SortedSetMultimap<String, String> multimap = MultimapBuilder.treeKeys().treeSetValues().build();
        multimap.put("k1", "v11");
        multimap.put("k1", "v12");
        multimap.put("k1", "v13");
        multimap.put("k2", "v2");
        multimap.put("k2", "v2");
        multimap.put("k3", "v3");

        Map<String, Collection<String>> map = multimap.asMap();
        assertThat(map).containsOnlyKeys("k1", "k2", "k3");
        assertThat(map.get("k1")).containsExactly("v11", "v12", "v13");
        assertThat(map.get("k2")).containsExactly("v2");
        assertThat(map.get("k3")).containsExactly("v3");

        Set<Map.Entry<String, String>> entries = multimap.entries();
        assertThat(entries).containsExactly(
                entry("k1", "v11"),
                entry("k1", "v12"),
                entry("k1", "v13"),
                entry("k2", "v2"),
                entry("k3", "v3")
        );

        Multiset<String> keys = multimap.keys();
        assertThat(keys).containsExactly("k1", "k1", "k1", "k2", "k3");

        Set<String> keySet = multimap.keySet();
        assertThat(keySet).containsExactly("k1", "k2", "k3");

        Collection<String> values = multimap.values();
        assertThat(values).containsExactly("v11", "v12", "v13", "v2", "v3");

        SortedSet<String> k1Values = multimap.get("k1");
        assertThat(k1Values).containsExactly("v11", "v12", "v13");
    }
}
