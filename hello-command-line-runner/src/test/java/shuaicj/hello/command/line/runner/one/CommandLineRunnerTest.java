package shuaicj.hello.command.line.runner.one;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test spring CommandLineRunner.
 *
 * @author shuaicj 2017/03/04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommandLineRunnerTest {

    @Test
    public void testRunner() {
        assertThat(StartupParam.get()).isEqualTo("onlyOneParam");
    }
}
