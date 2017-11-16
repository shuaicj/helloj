package shuaicj.hello.interf.defolt.method;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * Rule 1: Classes always win. A method declaration in the class or a superclass
 * takes priority over any default method declaration.
 *
 * Rule 2: Otherwise, sub-interfaces win. The method with the same signature in
 * the most specific default-providing interface is selected. (If B extends A,
 * B is more specific than A).
 *
 * Rule 3: Finally, if the choice is still ambiguous, the class inheriting from
 * multiple interfaces has to explicitly select which default method implementation
 * to use by overriding it and calling the desired method explicitly.
 *
 * Refer to 'Java 8 IN ACTION'
 *
 * @author shuaicj 2017/11/16
 */
public class DefaultMethodRuleTest {

    /**
     * Choose between interface A and class B.
     * Rule 1: B wins.
     */
    @Test
    public void testExample1() {
        assertThat(new Example1.C().hello()).isEqualTo("This is B");
    }

    static class Example1 {
        interface A {
            default String hello() {
                return "This is A";
            }
        }

        static class B implements A {
            public String hello() {
                return "This is B";
            }
        }

        static class C extends B implements A {}
    }

    /**
     * Choose between interface A and interface B.
     * Rule 2: B wins.
     */
    @Test
    public void testExample2() {
        assertThat(new Example2.C().hello()).isEqualTo("This is B");
    }

    static class Example2 {
        interface A {
            default String hello() {
                return "This is A";
            }
        }

        interface B extends A {
            default String hello() {
                return "This is B";
            }
        }

        static class C implements A, B {}
    }

    /**
     * Because class C doesn't implement the method itself,
     * choose between interface A and interface B.
     * Rule 2: B wins.
     */
    @Test
    public void testExample3() {
        assertThat(new Example3.D().hello()).isEqualTo("This is B");
    }

    static class Example3 {
        interface A {
            default String hello() {
                return "This is A";
            }
        }

        interface B extends A {
            default String hello() {
                return "This is B";
            }
        }

        static class C implements A {}

        static class D extends C implements B {}
    }

    /**
     * Choose between interface B and class C.
     * Rule 1: C wins.
     */
    @Test
    public void testExample4() {
        assertThat(new Example4.D().hello()).isEqualTo("This is C");
    }

    static class Example4 {
        interface A {
            default String hello() {
                return "This is A";
            }
        }

        interface B extends A {
            default String hello() {
                return "This is B";
            }
        }

        static class C implements A {
            public String hello() {
                return "This is C";
            }
        }

        static class D extends C implements B {}
    }

    /**
     * Choose between interface A and class C.
     * Rule 1: C wins.
     */
    @Test
    public void testExample5() {
        assertThat(new Example5.D().hello()).isEqualTo("This is C");
    }

    static class Example5 {
        interface A {
            default String hello() {
                return "This is A";
            }
        }

        interface B extends A {
            String hello();
        }

        static class C implements A {
            public String hello() {
                return "This is C";
            }
        }

        static class D extends C implements B {}
    }

    /**
     * When class C declares an abstract method, class D must provide implementation.
     * Or the compiler gives an error.
     */
    @Test
    public void testExample6() {
        assertThat(new Example6.D().hello()).isEqualTo("This is D");
    }

    static class Example6 {
        interface A {
            default String hello() {
                return "This is A";
            }
        }

        interface B extends A {
            default String hello() {
                return "This is B";
            }
        }

        static abstract class C implements A {
            public abstract String hello();
        }

        static class D extends C implements B {
            public String hello() {
                return "This is D";
            }
        }
    }

    /**
     * Rule 3: class C, D must provide implementation. Or the compiler gives an error.
     * If you need, C can explicitly call the method from A or B.
     */
    @Test
    public void testExample7() {
        assertThat(new Example7.C().hello()).isEqualTo("This is A");
        assertThat(new Example7.D().hello()).isEqualTo("This is D");
    }

    static class Example7 {
        interface A {
            default String hello() {
                return "This is A";
            }
        }

        interface B {
            default String hello() {
                return "This is B";
            }
        }

        static class C implements A, B {
            public String hello() {
                return A.super.hello();
            }
        }

        static class D implements A, B {
            public String hello() {
                return "This is D";
            }
        }
    }

    /**
     * The interface A and B have almost the same method signature.
     * The class C must provide implementation to return Integer. Or the compiler gives an error.
     */
    @Test
    public void testExample8() {
        assertThat(new Example8.C().hello()).isEqualTo(20);
        assertThat(new Example8.D().hello()).isEqualTo(30);
    }

    static class Example8 {
        interface A {
            default Number hello() {
                return 10;
            }
        }

        interface B {
            default Integer hello() {
                return 20;
            }
        }

        static class C implements A, B {
            public Integer hello() {
                return B.super.hello();
            }
        }

        static class D implements A, B {
            public Integer hello() {
                return 30;
            }
        }
    }

    /**
     * Only A provides a default method.
     */
    @Test
    public void testDiamondProblem1() {
        assertThat(new DiamondProblem1.D().hello()).isEqualTo("This is A");
    }

    static class DiamondProblem1 {
        interface A {
            default String hello() {
                return "This is A";
            }
        }

        interface B extends A {}

        interface C extends A {}

        static class D implements B, C {}
    }

    /**
     * Rule 2: B wins.
     */
    @Test
    public void testDiamondProblem2() {
        assertThat(new DiamondProblem2.D().hello()).isEqualTo("This is B");
    }

    static class DiamondProblem2 {
        interface A {
            default String hello() {
                return "This is A";
            }
        }

        interface B extends A {
            default String hello() {
                return "This is B";
            }
        }

        interface C extends A {}

        static class D implements B, C {}
    }

    /**
     * Rule 2: B wins.
     * So class D must provide the method implementation because it is declared abstract in B.
     * Or the compiler gives an error.
     */
    @Test
    public void testDiamondProblem3() {
        assertThat(new DiamondProblem3.D().hello()).isEqualTo("This is D");
    }

    static class DiamondProblem3 {
        interface A {
            default String hello() {
                return "This is A";
            }
        }

        interface B extends A {
            String hello();
        }

        interface C extends A {}

        static class D implements B, C {
            public String hello() {
                return "This is D";
            }
        }
    }

    /**
     * Rule 3: class D must provide the method implementation.
     * Or the compiler gives an error.
     */
    @Test
    public void testDiamondProblem4() {
        assertThat(new DiamondProblem4.D().hello()).isEqualTo("This is D");
    }

    static class DiamondProblem4 {
        interface A {
            default String hello() {
                return "This is A";
            }
        }

        interface B extends A {
            default String hello() {
                return "This is B";
            }
        }

        interface C extends A {
            default String hello() {
                return "This is C";
            }
        }

        static class D implements B, C {
            public String hello() {
                return "This is D";
            }
        }
    }
}

