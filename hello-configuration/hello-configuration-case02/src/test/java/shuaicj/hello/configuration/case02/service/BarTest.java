package shuaicj.hello.configuration.case02.service;

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
     * The override-B is declared in method overrideB() (annotated by @Bean) in class OverrideB (annotated by @Configuration).
     *
     * Failed to load ApplicationContext. Invalid bean definition with name 'overrideB': factory-bean reference points back
     * to the same bean definition
     */
    @Test
    public void testB() {
        // assertThat(bar.getB().getName()).isEqualTo("override-B");
    }

    @Test
    public void testC() {
        assertThat(bar.getC().getName()).isEqualTo("default-C");
    }

    /**
     * The default-Foo is declared in class Foo (annotated by @Service).
     * The override-Foo is declared in method overrideFoo() (annotated by @Bean) in class OverrideFoo (annotated by @Configuration).
     *
     * Failed to load ApplicationContext. Invalid bean definition with name 'overrideFoo': factory-bean reference points back
     * to the same bean definition
     */
    @Test
    public void testFoo() {
        // assertThat(bar.getFoo().getName()).isEqualTo("override-Foo");
    }

}