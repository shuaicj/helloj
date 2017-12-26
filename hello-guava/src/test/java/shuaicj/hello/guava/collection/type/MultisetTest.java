package shuaicj.hello.guava.collection.type;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;
import org.junit.Test;

/**
 * Test Multiset.
 *
 * @author shuaicj 2017/12/26
 */
public class MultisetTest {

    @Test
    public void testHashMultiset() {
        Multiset<String> set = HashMultiset.create();
        set.add("a");
        set.add("b");
        set.add("a", 3);

        assertThat(set.count("a")).isEqualTo(4);
        assertThat(set.count("b")).isEqualTo(1);
        assertThat(set.count("c")).isEqualTo(0);
        assertThat(set.size()).isEqualTo(5);

        set.remove("a");
        assertThat(set.count("a")).isEqualTo(3);

        set.remove("a", 2);
        assertThat(set.count("a")).isEqualTo(1);

        set.remove("a", 100);
        assertThat(set.count("a")).isEqualTo(0);

        set.setCount("a", 30);
        assertThat(set.count("a")).isEqualTo(30);
    }

    @Test
    public void testTreeMultiset() {
        Multiset<String> set = TreeMultiset.create(Arrays.asList("c", "a", "b", "a"));
        assertThat(set).containsExactly("a", "a", "b", "c");
    }
}
