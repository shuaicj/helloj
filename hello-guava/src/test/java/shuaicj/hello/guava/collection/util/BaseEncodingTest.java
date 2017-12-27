package shuaicj.hello.guava.collection.util;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.io.BaseEncoding;
import org.junit.Test;

/**
 * Test BaseEncoding.
 *
 * @author shuaicj 2017/12/27
 */
public class BaseEncodingTest {

    private static final byte[] DATA = new byte[]{(byte) 0x01, (byte) 0xf2, (byte) 0xd3};

    @Test
    public void encode() {
        assertThat(BaseEncoding.base16().encode(DATA)).isEqualTo("01F2D3");
        assertThat(BaseEncoding.base16().lowerCase().encode(DATA)).isEqualTo("01f2d3");
    }

    @Test
    public void decode() {
        assertThat(BaseEncoding.base16().decode("01F2D3")).isEqualTo(DATA);
        assertThat(BaseEncoding.base16().lowerCase().decode("01f2d3")).isEqualTo(DATA);
    }
}
