package shuaicj.hello.configuration.case12.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shuaicj.hello.configuration.case12.bean.B;

/**
 * Override B.
 *
 * @author shuaicj 2019/10/12
 */
@Configuration
public class OverrideB {

    @Bean
    public B overrideB() {
        return new B("override-B");
    }
}