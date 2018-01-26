package shuaicj.hello.runtime.version;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * Test Java 9 {@link java.lang.Runtime.Version}.
 *
 * @author shuaicj 2018/01/26
 */
public class VersionTest {

    @Test
    public void test() {
        Runtime.Version version = Runtime.Version.parse("9.0.1-ea+132-20170130.07.36am");
        assertThat(version.major()).isEqualTo(9);
        assertThat(version.minor()).isEqualTo(0);
        assertThat(version.security()).isEqualTo(1);
        assertThat(version.pre()).contains("ea");
        assertThat(version.build()).contains(132);
        assertThat(version.optional()).contains("20170130.07.36am");
    }
}
