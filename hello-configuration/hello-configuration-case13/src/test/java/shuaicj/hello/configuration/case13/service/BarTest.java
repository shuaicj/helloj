package shuaicj.hello.configuration.case13.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shuaicj.hello.configuration.case13.Application;
import shuaicj.hello.configuration.case13.config.OverrideB;
import shuaicj.hello.configuration.case13.config.OverrideFoo;

/**
 * Test Bar.
 * The classes order in @SpringBootTest is important.
 *
 * @author shuaicj 2019/10/12
 */
@SpringBootTest(classes = {Application.class, OverrideB.class, OverrideFoo.class})
// @SpringBootTest(classes = {OverrideB.class, OverrideFoo.class, Application.class})
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
     * The override-B is declared in method b() (annotated by @Bean) in class OverrideB (annotated by @TestConfiguration,
     * and specified by @SpringBootTest).
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
     * The override-Foo is declared in method foo() (annotated by @Bean) in class OverrideFoo (annotated by @TestConfiguration,
     * and specified by @SpringBootTest).
     *
     * The override-Foo is created and injected.
     */
    @Test
    public void testFoo() {
        assertThat(bar.getFoo().getName()).isEqualTo("override-Foo");
    }

}