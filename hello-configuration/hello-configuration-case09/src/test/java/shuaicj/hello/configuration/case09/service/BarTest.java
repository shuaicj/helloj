package shuaicj.hello.configuration.case09.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import shuaicj.hello.configuration.case09.bean.A;
import shuaicj.hello.configuration.case09.bean.B;
import shuaicj.hello.configuration.case09.bean.C;

/**
 * Test Bar.
 *
 * @author shuaicj 2019/10/12
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BarTest {

    @Autowired
    Bar bar;

    @Test
    public void testA() {
        assertThat(bar.getA().getName()).isEqualTo("default-A");
    }

    /**
     * The default-B is declared in method b() (annotated by @Bean) in class DefaultBC (annotated by @Configuration).
     * The override-B is declared in method b() (annotated by @Bean) in static inner class (annotated by @TestConfiguration).
     *
     * The override-B is created and injected.
     */
    @Test
    public void testB() {
        assertThat(bar.getB().getName()).isEqualTo("override-B");
    }

    @Test
    public void testC() {
        assertThat(bar.getC().getName()).isEqualTo("default-C");
    }

    /**
     * The default-Foo is declared in class Foo (annotated by @Service).
     * The override-Foo is declared in method foo() (annotated by @Bean) in static inner class (annotated by @TestConfiguration).
     *
     * The override-Foo is created and injected.
     */
    @Test
    public void testFoo() {
        assertThat(bar.getFoo().getName()).isEqualTo("override-Foo");
    }

    /**
     * This static inner class (annotated by @TestConfiguration) will be used in addition to the primary configuration
     * class Application (annotated by @SpringBootApplication).
     */
    @TestConfiguration
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