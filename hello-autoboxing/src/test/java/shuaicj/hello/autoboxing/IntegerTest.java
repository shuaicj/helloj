package shuaicj.hello.autoboxing;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test Integer.
 *
 * 1. Constructors always creates new object.
 * 2. Literal assignment and valueOf return:
 *     2.1 cached Integer [-128,127]
 *     2.2 new Integer object if out of the range
 *
 * The range may be controlled by the {@code -XX:AutoBoxCacheMax=<size>} jvm option.
 *
 * Short and Long have the same range as Integer.
 *
 * See the private static class IntegerCache, ShortCache, LongCache.
 *
 * @author shuaicj 2017/02/13
 */
@SuppressWarnings({"UnnecessaryBoxing", "NumberEquality"})
public class IntegerTest {

    @Test
    public void ctor() throws Exception {
        Integer o1 = new Integer(10);
        Integer o2 = new Integer(10);
        assertTrue(o1 != o2);
    }

    @Test
    public void assign() throws Exception {
        Integer o1 = 10;
        Integer o2 = 10;
        Integer o3 = new Integer(10);
        assertTrue(o1 == o2);
        assertTrue(o1 != o3);
    }

    @Test
    public void valueOf() throws Exception {
        Integer o1 = 10;
        Integer o2 = Integer.valueOf(10);
        Integer o3 = Integer.valueOf(10);
        assertTrue(o1 == o2);
        assertTrue(o2 == o3);
    }

    @Test
    public void valueOfRange() throws Exception {
        Integer o1 = -128;
        Integer o2 = Integer.valueOf(-128);
        assertTrue(o1 == o2);
        Integer o3 = 127;
        Integer o4 = Integer.valueOf(127);
        assertTrue(o3 == o4);
        Integer o5 = -129;
        Integer o6 = Integer.valueOf(-129);
        assertTrue(o5 != o6);
        Integer o7 = 128;
        Integer o8 = Integer.valueOf(128);
        assertTrue(o7 != o8);
    }

    @Test
    public void valueOfLongRange() throws Exception {
        Long o1 = -128L;
        Long o2 = Long.valueOf(-128L);
        assertTrue(o1 == o2);
        Long o3 = 127L;
        Long o4 = Long.valueOf(127L);
        assertTrue(o3 == o4);
        Long o5 = -129L;
        Long o6 = Long.valueOf(-129L);
        assertTrue(o5 != o6);
        Long o7 = 128L;
        Long o8 = Long.valueOf(128L);
        assertTrue(o7 != o8);
    }
}
