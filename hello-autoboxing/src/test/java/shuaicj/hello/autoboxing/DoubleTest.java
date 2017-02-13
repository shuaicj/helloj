package shuaicj.hello.autoboxing;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test Double.
 *
 * 1. Constructors, Literal assignment, valueOf always creates new object.
 * 2. No cache exists.
 *
 * Float acts the same as Double.
 *
 * @author shuaicj 2017/02/13
 */
@SuppressWarnings({"UnnecessaryBoxing", "NumberEquality"})
public class DoubleTest {

    @Test
    public void ctor() throws Exception {
        Double o1 = new Double(10.0);
        Double o2 = new Double(10.0);
        assertTrue(o1 != o2);
    }

    @Test
    public void assign() throws Exception {
        Double o1 = 10.0;
        Double o2 = 10.0;
        Double o3 = new Double(10.0);
        assertTrue(o1 != o2);
        assertTrue(o1 != o3);
        assertTrue(o2 != o3);
    }

    @Test
    public void valueOf() throws Exception {
        Double o1 = 10.0;
        Double o2 = Double.valueOf(10.0);
        Double o3 = Double.valueOf(10.0);
        assertTrue(o1 != o2);
        assertTrue(o1 != o3);
        assertTrue(o2 != o3);
    }
}
