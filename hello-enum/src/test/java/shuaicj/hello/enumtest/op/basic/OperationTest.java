package shuaicj.hello.enumtest.op.basic;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test Operation.
 *
 * @author shuaicj 2017/02/05
 */
public class OperationTest {

    @Test
    public void apply() throws Exception {
        assertThat(Operation.PLUS.apply(1, 2)).isEqualTo(3);
        assertThat(Operation.MINUS.apply(1, 2)).isEqualTo(-1);
        assertThat(Operation.TIMES.apply(2, 3)).isEqualTo(6);
        assertThat(Operation.DIVIDE.apply(9, 3)).isEqualTo(3);
    }

    @Test
    public void name() throws Exception {
        assertThat(Operation.PLUS.name()).isEqualTo("PLUS");
        assertThat(Operation.MINUS.name()).isEqualTo("MINUS");
        assertThat(Operation.TIMES.name()).isEqualTo("TIMES");
        assertThat(Operation.DIVIDE.name()).isEqualTo("DIVIDE");
    }

    @Test
    public void symbol() throws Exception {
        assertThat(Operation.PLUS.toString()).isEqualTo("+");
        assertThat(Operation.MINUS.toString()).isEqualTo("-");
        assertThat(Operation.TIMES.toString()).isEqualTo("*");
        assertThat(Operation.DIVIDE.toString()).isEqualTo("/");
    }

    @Test
    public void valueOf() throws Exception {
        assertThat(Operation.valueOf("PLUS")).isEqualTo(Operation.PLUS);
        assertThat(Operation.valueOf("MINUS")).isEqualTo(Operation.MINUS);
        assertThat(Operation.valueOf("TIMES")).isEqualTo(Operation.TIMES);
        assertThat(Operation.valueOf("DIVIDE")).isEqualTo(Operation.DIVIDE);
    }

    @Test
    public void fromString() throws Exception {
        assertThat(Operation.fromString("+")).isEqualTo(Operation.PLUS);
        assertThat(Operation.fromString("-")).isEqualTo(Operation.MINUS);
        assertThat(Operation.fromString("*")).isEqualTo(Operation.TIMES);
        assertThat(Operation.fromString("/")).isEqualTo(Operation.DIVIDE);
    }

}