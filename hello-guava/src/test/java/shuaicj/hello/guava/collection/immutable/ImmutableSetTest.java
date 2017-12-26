package shuaicj.hello.guava.collection.immutable;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import org.junit.Test;

/**
 * Test ImmutableSet and ImmutableSortedSet.
 *
 * @author shuaicj 2017/12/26
 */
public class ImmutableSetTest {

    @Test
    public void testImmutableSet() {
        ImmutableSet<String> set1 = ImmutableSet.of("a", "b", "c", "b");
        assertThat(set1).containsExactlyInAnyOrder("a", "b", "c");
        ImmutableSet<String> set2 = ImmutableSet.copyOf(Arrays.asList("a", "b", "c", "b"));
        assertThat(set2).containsExactlyInAnyOrder("a", "b", "c");
    }

    @Test
    public void testImmutableSortedSet() {
        ImmutableSet<String> set1 = ImmutableSortedSet.of("a", "b", "c", "b");
        assertThat(set1).containsExactly("a", "b", "c");
        ImmutableSet<String> set2 = ImmutableSortedSet.copyOf(Arrays.asList("a", "b", "c", "b"));
        assertThat(set2).containsExactly("a", "b", "c");
    }
}
