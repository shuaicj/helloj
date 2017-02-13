package shuaicj.hello.autoboxing;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test Byte.
 *
 * 1. Constructors always creates new object.
 * 2. Literal assignment and valueOf always return cached Byte [-128,127].
 *
 * @author shuaicj 2017/02/13
 */
@SuppressWarnings({"UnnecessaryBoxing", "NumberEquality"})
public class ByteTest {

    @Test
    public void ctor() throws Exception {
        Byte o1 = new Byte((byte) 10);
        Byte o2 = new Byte((byte) 10);
        assertTrue(o1 != o2);
    }

    @Test
    public void assign() throws Exception {
        Byte o1 = 10;
        Byte o2 = 10;
        Byte o3 = new Byte((byte) 10);
        assertTrue(o1 == o2);
        assertTrue(o1 != o3);
    }

    @Test
    public void valueOf() throws Exception {
        Byte o1 = 10;
        Byte o2 = Byte.valueOf((byte) 10);
        Byte o3 = Byte.valueOf((byte) 10);
        assertTrue(o1 == o2);
        assertTrue(o2 == o3);
    }

    @Test
    public void valueOfRange() throws Exception {
        Byte o1 = Byte.valueOf(Byte.MAX_VALUE);
        Byte o2 = Byte.valueOf(Byte.MAX_VALUE);
        Byte o3 = Byte.valueOf(Byte.MIN_VALUE);
        Byte o4 = Byte.valueOf(Byte.MIN_VALUE);
        assertTrue(o1 == o2);
        assertTrue(o1 == Byte.MAX_VALUE);
        assertTrue(o3 == o4);
        assertTrue(o3 == Byte.MIN_VALUE);
    }
}
