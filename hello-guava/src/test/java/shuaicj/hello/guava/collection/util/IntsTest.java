package shuaicj.hello.guava.collection.util;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.primitives.Ints;
import org.junit.Test;

/**
 * Test Ints.
 *
 * @author shuaicj 2017/12/26
 */
public class IntsTest {

    @Test
    public void asList() {
        assertThat(Ints.asList(2, 1, 3)).containsExactly(2, 1, 3);
    }

    @Test
    public void compare() {
        assertThat(Ints.compare(1, 2)).isLessThan(0);
        assertThat(Ints.compare(2, 2)).isEqualTo(0);
        assertThat(Ints.compare(3, 2)).isGreaterThan(0);
    }

    @Test
    public void concat() {
        assertThat(Ints.concat(
                new int[]{2, 3},
                new int[]{1},
                new int[]{4, 8}
        )).containsExactly(2, 3, 1, 4, 8);
    }

    @Test
    public void fromBytes() {
        assertThat(Ints.fromByteArray(new byte[]{1, 2, 3, 4})).isEqualTo(0x01020304);
        assertThat(Ints.fromBytes((byte) 1, (byte) 2, (byte) 3, (byte) 4)).isEqualTo(0x01020304);
    }

    @Test
    public void toBytes() {
        assertThat(Ints.toByteArray(0x01020304)).containsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4);
    }

    @Test
    public void indexOf() {
        assertThat(Ints.indexOf(new int[]{1, 2, 3, 4}, 3)).isEqualTo(2);
        assertThat(Ints.indexOf(new int[]{1, 2, 3, 4}, 5)).isEqualTo(-1);
        assertThat(Ints.indexOf(new int[]{1, 2, 3, 4}, new int[]{2, 3})).isEqualTo(1);
        assertThat(Ints.indexOf(new int[]{1, 2, 3, 4}, new int[]{4, 3})).isEqualTo(-1);
    }

    @Test
    public void join() {
        assertThat(Ints.join("|", 1, 2, 3, 4)).isEqualTo("1|2|3|4");
    }

    @Test
    public void max() {
        assertThat(Ints.max(1, 2, 3, 4)).isEqualTo(4);
    }

    @Test
    public void min() {
        assertThat(Ints.min(1, 2, 3, 4)).isEqualTo(1);
    }

    @Test
    public void reverse() {
        int[] arr = new int[]{1, 2, 3, 4};
        Ints.reverse(arr);
        assertThat(arr).containsExactly(4, 3, 2, 1);
    }
}
