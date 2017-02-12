package shuaicj.hello.asserttest;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Test java key word: assert.
 *
 * @author shuaicj 2017/02/12
 */
public class AssertTest {

    @Test
    public void shouldThrowAssertionError() {
        Assertions.assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> assertPositive(-1));
    }

    @Test
    public void shouldThrowAssertionErrorWithMessage() {
        Assertions.assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> assertPositiveWithMessage(-1))
                .withMessage("Positive param required");
    }

    private void assertPositive(int i) {
        assert i > 0;
    }

    private void assertPositiveWithMessage(int i) {
        assert i > 0 : "Positive param required";
    }
}
