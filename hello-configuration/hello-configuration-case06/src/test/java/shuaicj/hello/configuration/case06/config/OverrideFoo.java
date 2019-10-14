package shuaicj.hello.configuration.case06.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import shuaicj.hello.configuration.case06.service.Foo;

/**
 * Override Foo.
 *
 * @author shuaicj 2019/10/12
 */
@TestConfiguration
public class OverrideFoo {

    @Bean
    public Foo overrideFoo() {
        return new Foo("override-Foo");
    }
}