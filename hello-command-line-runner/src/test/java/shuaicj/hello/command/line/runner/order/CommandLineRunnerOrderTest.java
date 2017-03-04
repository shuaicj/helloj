package shuaicj.hello.command.line.runner.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test spring CommandLineRunner with order.
 *
 * @author shuaicj 2017/03/04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommandLineRunnerOrderTest {

    @Test
    public void testRunner() {
        assertThat(StartupParams.get()).containsExactly("1stParam", "2ndParam", "3rdParam");
    }
}
