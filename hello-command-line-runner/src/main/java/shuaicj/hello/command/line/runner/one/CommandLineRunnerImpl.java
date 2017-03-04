package shuaicj.hello.command.line.runner.one;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Implementation of CommandLineRunner.
 *
 * @author shuaicj 2017/03/04
 */
@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        StartupParam.set("onlyOneParam");
    }
}
