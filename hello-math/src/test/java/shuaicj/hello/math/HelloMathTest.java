package shuaicj.hello.math;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

}