package shuaicj.hello.configuration.case03.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
     * The override-B is declared in method b() (annotated by @Bean) in class OverrideB (annotated by @TestConfiguration).
     *
     * The default-B is created and injected.
     * The @TestConfiguration is skipped by spring.
     */
    @Test
    public void testB() {
        assertThat(bar.getB().getName()).isEqualTo("default-B");
    }

    @Test
    public void testC() {
        assertThat(bar.getC().getName()).isEqualTo("default-C");
    }

    /**
     * The default-Foo is declared in class Foo (annotated by @Service).
     * The override-Foo is declared in method foo() (annotated by @Bean) in class OverrideFoo (annotated by @TestConfiguration).
     *
     * The default-Foo is created and injected.
     * The @TestConfiguration is skipped by spring.
     */
    @Test
    public void testFoo() {
        assertThat(bar.getFoo().getName()).isEqualTo("default-Foo");
    }

}