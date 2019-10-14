package shuaicj.hello.configuration.case07.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import shuaicj.hello.configuration.case07.bean.A;
import shuaicj.hello.configuration.case07.bean.B;
import shuaicj.hello.configuration.case07.bean.C;

/**
 * Test Bar.
 *
 * @author shuaicj 2019/10/12
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BarTest {

    @Autowired(required = false)
    A a;

    @Autowired
    B b;

    @Autowired(required = false)
    C c;

    @Autowired
    Foo foo;

    @Autowired(required = false)
    Bar bar;

    @Test
    public void testA() {
        assertThat(a).isNull();
    }

    @Test
    public void testB() {
        assertThat(b.getName()).isEqualTo("override-B");
    }

    @Test
    public void testC() {
        assertThat(c).isNull();
    }

    @Test
    public void testFoo() {
        assertThat(foo.getName()).isEqualTo("override-Foo");
    }

    @Test
    public void testBar() {
        assertThat(bar).isNull();
    }

    /**
     * This static inner class (annotated by @Configuration) will replace the primary configuration
     * class Application (annotated by @SpringBootApplication). So only beans declared here will be created and injected.
     */
    @Configuration
    static class Config {

        @Bean
        public B b() {
            return new B("override-B");
        }

        @Bean
        public Foo foo() {
            return new Foo("override-Foo");
        }
    }
}