package shuaicj.hello.command.line.runner.order;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Implementation of CommandLineRunner with order.
 *
 * @author shuaicj 2017/03/04
 */
@Component
@Order(1)
public class CommandLineRunnerImpl1 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        StartupParams.add("1stParam");
    }
}
