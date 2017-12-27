package shuaicj.hello.guava.collection.immutable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

/**
 * Test ImmutableList.
 *
 * @author shuaicj 2017/12/27
 */
public class ImmutableListTest {

    @Test
    @SuppressWarnings("deprecation")
    public void immutable() {
        ImmutableList<String> list = ImmutableList.of("a", "b", "c", "b");
        assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> list.add("e"));
    }

    @Test
    public void test() {
        ImmutableList<String> list = ImmutableList.of("a", "b", "c", "b");
        assertThat(list).containsExactly("a", "b", "c", "b");
    }
}
