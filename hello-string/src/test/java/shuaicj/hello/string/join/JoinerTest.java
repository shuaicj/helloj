package shuaicj.hello.string.join;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.StringJoiner;

import org.junit.Test;

/**
 * Test {@link java.util.StringJoiner}.
 *
 * @author shuaicj 2019/03/01
 */
public class JoinerTest {

    @Test
    public void testDelimiter() {
        StringJoiner joiner = new StringJoiner(" and ");
        assertThat(joiner).hasToString("");
        joiner.add("a = ?");
        assertThat(joiner).hasToString("a = ?");
        joiner.add("b = ?");
        assertThat(joiner).hasToString("a = ? and b = ?");
    }

    @Test
    public void testPrefixAndSuffix() {
        StringJoiner joiner = new StringJoiner(" and ", "where ", ";");
        assertThat(joiner).hasToString("where ;");
        joiner.add("a = ?");
        assertThat(joiner).hasToString("where a = ?;");
        joiner.add("b = ?");
        assertThat(joiner).hasToString("where a = ? and b = ?;");
    }

    @Test
    public void testEmptyValue() {
        StringJoiner joiner = new StringJoiner(" and ", "where ", ";");
        joiner.setEmptyValue("");
        assertThat(joiner).hasToString("");
        joiner.add("a = ?");
        assertThat(joiner).hasToString("where a = ?;");
        joiner.add("b = ?");
        assertThat(joiner).hasToString("where a = ? and b = ?;");
    }
}
