package shuaicj.hello.configuration.case14.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import shuaicj.hello.configuration.case14.bean.B;

/**
 * Override B.
 *
 * @author shuaicj 2019/10/12
 */
@TestConfiguration
public class OverrideB {

    @Bean
    public B overrideB() {
        return new B("override-B");
    }
}