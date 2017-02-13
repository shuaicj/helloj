package shuaicj.hello.autoboxing;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test Boolean.
 *
 * 1. Constructors always creates new object.
 * 2. Literal assignment and valueOf always return Boolean.TRUE or Boolean.False.
 *
 * @author shuaicj 2017/02/13
 */
@SuppressWarnings("BooleanConstructorCall")
public class BooleanTest {

    @Test
    public void ctor() throws Exception {
        Boolean o1 = new Boolean("true");
        Boolean o2 = new Boolean("true");
        assertTrue(o1 != o2);
        assertTrue(o1 != Boolean.TRUE);
    }

    @Test
    public void assign() throws Exception {
        Boolean o1 = true;
        Boolean o2 = true;
        Boolean o3 = new Boolean("true");
        assertTrue(o1 == o2);
        assertTrue(o1 != o3);
        assertTrue(o1 == Boolean.TRUE);
    }

    @Test
    public void valueOf() throws Exception {
        Boolean o1 = true;
        Boolean o2 = Boolean.valueOf("true");
        Boolean o3 = Boolean.valueOf("true");
        assertTrue(o1 == o2);
        assertTrue(o2 == o3);
    }
}
