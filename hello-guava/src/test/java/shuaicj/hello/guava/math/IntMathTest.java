package shuaicj.hello.guava.math;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.RoundingMode;

import com.google.common.math.IntMath;
import org.junit.Test;

/**
 * Test IntMath.
 *
 * @author shuaicj 2018/01/08
 */
public class IntMathTest {

    @Test
    public void ok() {
        assertThat(IntMath.checkedAdd(1, 2)).isEqualTo(3);
    }

    @Test(expected = ArithmeticException.class)
    public void overflow() {
        IntMath.checkedAdd(Integer.MAX_VALUE, 1);
    }

    @Test
    public void divide() {
        assertThat(3 / 2).isEqualTo(1);
        assertThat(IntMath.divide(3, 2, RoundingMode.HALF_EVEN)).isEqualTo(2);
    }

    @Test
    public void gcd() {
        assertThat(IntMath.gcd(45, 60)).isEqualTo(15);
    }

    @Test
    public void factorial() {
        assertThat(IntMath.factorial(5)).isEqualTo(120); // 5! = 5 * 4 * 3 * 2 * 1
    }

    @Test
    public void is() {
        assertThat(IntMath.isPowerOfTwo(1024)).isTrue();
        assertThat(IntMath.isPowerOfTwo(1023)).isFalse();
    }
}
