package shuaicj.hello.guava.collection.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import com.google.common.collect.Sets;
import org.junit.Test;

/**
 * Test Sets.
 *
 * @author shuaicj 2017/12/26
 */
public class SetsTest {

    @Test
    public void intersection() {
        Set<String> set1 = Sets.newHashSet("a", "b", "c");
        Set<String> set2 = Sets.newHashSet("b", "c", "d");
        assertThat(Sets.intersection(set1, set2)).containsExactlyInAnyOrder("b", "c");
    }

    @Test
    public void union() {
        Set<String> set1 = Sets.newHashSet("a", "b", "c");
        Set<String> set2 = Sets.newHashSet("b", "c", "d");
        assertThat(Sets.union(set1, set2)).containsExactlyInAnyOrder("a", "b", "c", "d");
    }
}
