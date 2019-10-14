package shuaicj.hello.configuration.case07.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shuaicj.hello.configuration.case07.bean.A;

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
