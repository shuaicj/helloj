package shuaicj.hello.digest.utils;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.DigestUtils;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test spring DigestUtils.
 *
 * @author shuaicj 2017/01/20
 */
public class DigestUtilsTest {

    @Test
    public void testString() throws Exception {
        String md5 = DigestUtils.md5DigestAsHex("shuaicj".getBytes());
        assertThat(md5).isEqualTo("14e90cb53508f517852f3038c7ece80c");
    }

    @Test
    public void testFile() throws Exception {
        String md5 = DigestUtils.md5DigestAsHex(new ClassPathResource("name.txt").getInputStream());
        assertThat(md5).isEqualTo("14e90cb53508f517852f3038c7ece80c");
    }
}
