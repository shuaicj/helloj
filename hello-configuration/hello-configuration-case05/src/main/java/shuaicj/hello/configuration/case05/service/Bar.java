package shuaicj.hello.configuration.case05.service;

import org.springframework.stereotype.Service;
import shuaicj.hello.configuration.case05.bean.A;
import shuaicj.hello.configuration.case05.bean.B;
import shuaicj.hello.configuration.case05.bean.C;

/**
 * A bar service.
 *
 * @author shuaicj 2019/10/12
 */
@Service
public class Bar {

    private final A a;
    private final B b;
    private final C c;
    private final Foo foo;

    public Bar(A a, B b, C c, Foo foo) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.foo = foo;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    public C getC() {
        return c;
    }

    public Foo getFoo() {
        return foo;
    }
}
