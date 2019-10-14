package shuaicj.hello.configuration.case01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shuaicj.hello.configuration.case01.bean.A;

/**
 * Config default A.
 *
 * @author shuaicj 2019/10/12
 */
@Configuration
public class DefaultA {

    @Bean
    public A a() {
        return new A("default-A");
    }
}
