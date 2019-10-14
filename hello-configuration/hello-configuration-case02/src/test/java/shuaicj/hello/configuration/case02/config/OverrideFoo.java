package shuaicj.hello.configuration.case02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shuaicj.hello.configuration.case02.service.Foo;

/**
 * Override Foo.
 *
 * @author shuaicj 2019/10/12
 */
@Configuration
public class OverrideFoo {

    // @Bean
    // public Foo overrideFoo() {
    //     return new Foo("override-Foo");
    // }
}