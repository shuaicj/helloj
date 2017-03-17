package shuaicj.hello.output.capture;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test spring OutputCapture.
 *
 * @author shuaicj 2017/03/17
 */
public class OutputCaptureTest {

    @Rule
    public OutputCapture capture = new OutputCapture();

    @Test
    public void stdOut() {
        System.out.print("hello stdout");
        assertThat(capture.toString()).isEqualTo("hello stdout");
    }

    @Test
    public void stdErr() {
        System.err.print("hello stderr");
        assertThat(capture.toString()).isEqualTo("hello stderr");
    }

    @Test
    public void stdOutErr() {
        System.out.print("hello stdout");
        System.err.print("hello stderr");
        assertThat(capture.toString()).isEqualTo("hello stdouthello stderr");
    }

    @Test
    public void stdErrOut() {
        System.err.print("hello stderr");
        System.out.print("hello stdout");
        assertThat(capture.toString()).isEqualTo("hello stderrhello stdout");
    }
}
