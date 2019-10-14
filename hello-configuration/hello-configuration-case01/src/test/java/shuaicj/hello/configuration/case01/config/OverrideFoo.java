package shuaicj.hello.configuration.case01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shuaicj.hello.configuration.case01.service.Foo;

/**
 * Override Foo.
 *
 * @author shuaicj 2019/10/12
 */
@Configuration
public class OverrideFoo {

    @Bean
    public Foo foo() {
        return new Foo("override-Foo");
    }
}