package shuaicj.hello.guava.collection.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.google.common.collect.Lists;
import org.junit.Test;

/**
 * Test Lists.
 *
 * @author shuaicj 2017/12/26
 */
public class ListsTest {

    @Test
    public void create() {
        assertThat(Lists.newArrayList("a")).containsExactly("a");
        assertThat(Lists.newArrayList("a", "c")).containsExactly("a", "c");
        assertThat(Lists.newArrayList("b", "a", "c")).containsExactly("b", "a", "c");
    }

    @Test
    public void charactersOf() {
        assertThat(Lists.charactersOf("abc")).containsExactly('a', 'b', 'c');
    }

    @Test
    public void reverse() {
        assertThat(Lists.reverse(Lists.newArrayList("b", "a", "c"))).containsExactly("c", "a", "b");
    }

    @Test
    public void partition() {
        List<List<String>> partitions = Lists.partition(Lists.newArrayList("b", "a", "c", "e", "f"), 2);
        assertThat(partitions.size()).isEqualTo(3);
        assertThat(partitions.get(0)).containsExactly("b", "a");
        assertThat(partitions.get(1)).containsExactly("c", "e");
        assertThat(partitions.get(2)).containsExactly("f");
    }
}
