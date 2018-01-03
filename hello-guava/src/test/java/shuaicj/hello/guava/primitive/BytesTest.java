package shuaicj.hello.guava.primitive;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.primitives.Bytes;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import org.junit.Test;

/**
 * Test Bytes.
 *
 * @author shuaicj 2017/12/27
 */
public class BytesTest {

    @Test
    public void asList() {
        assertThat(Bytes.asList((byte) 2, (byte) 1, (byte) 3)).containsExactly((byte) 2, (byte) 1, (byte) 3);
    }

    @Test
    public void concat() {
        assertThat(Bytes.concat(
                new byte[]{2, 3},
                new byte[]{1},
                new byte[]{4, 8}
        )).containsExactly((byte) 2, (byte) 3, (byte) 1, (byte) 4, (byte) 8);
    }

    @Test
    public void compare() {
        assertThat(SignedBytes.compare((byte) -127, (byte) 127)).isLessThan(0);
        assertThat(UnsignedBytes.compare((byte) -127, (byte) 127)).isGreaterThan(0);
    }

    @Test
    public void stringOps() {
        assertThat(UnsignedBytes.toString((byte) 127)).isEqualTo("127");
        assertThat(UnsignedBytes.toString((byte) -127)).isEqualTo("129");
        assertThat(UnsignedBytes.parseUnsignedByte("127")).isEqualTo((byte) 127);
        assertThat(UnsignedBytes.parseUnsignedByte("129")).isEqualTo((byte) -127);

        assertThat(UnsignedBytes.toString((byte) 0x7f, 16)).isEqualTo("7f");
        assertThat(UnsignedBytes.toString((byte) 0x8f, 16)).isEqualTo("8f");
        assertThat(UnsignedBytes.parseUnsignedByte("7f", 16)).isEqualTo((byte) 0x7f);
        assertThat(UnsignedBytes.parseUnsignedByte("8f", 16)).isEqualTo((byte) 0x8f);
    }

    @Test
    public void toInt() {
        assertThat(UnsignedBytes.toInt((byte) 127)).isEqualTo(127);
        assertThat(UnsignedBytes.toInt((byte) -127)).isEqualTo(129);
    }
}
