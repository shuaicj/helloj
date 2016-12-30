package shuaicj.hello.math;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.within;

/**
 * Description.
 *
 * @author shuaicj 2016/12/28
 */
public class HelloMathTest {

    private HelloMath math = new HelloMath();

    @Test
    public void add() throws Exception {
        assertThat(math.add(1, 2)).isEqualTo(3);
        assertThat(math.add(2, 3)).isEqualTo(5);
    }

    @Test
    public void sub() throws Exception {
        assertThat(math.sub(2, 1)).isEqualTo(1);
        assertThat(math.sub(3, 1)).isEqualTo(2);
    }

    @Test
    public void sqrt() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> math.sqrt(0.5, 0.1));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> math.sqrt(9, -0.1));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> math.sqrt(9, 2));
        assertThat(math.sqrt(3*3, 0.1)).isCloseTo(3, within(0.1));
        assertThat(math.sqrt(19*19, 0.5)).isCloseTo(19, within(0.5));
    }

}