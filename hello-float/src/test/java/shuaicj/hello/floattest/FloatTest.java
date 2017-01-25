package shuaicj.hello.floattest;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test Float.
 * Double has the same rule.
 *
 * @author shuaicj 2017/01/25
 */
public class FloatTest {

    @Test
    public void testFloatEquals() throws Exception {
        assertTrue(0.0f == -0.0f);
        assertFalse(new Float(0.0f).equals(-0.0f));
        assertFalse(new Float(0.0f).equals(new Float(-0.0f)));

        assertFalse(Float.NaN == Float.NaN);
        assertFalse(Float.NaN == -Float.NaN);
        assertTrue(new Float(Float.NaN).equals(Float.NaN));
        assertTrue(new Float(Float.NaN).equals(-Float.NaN));
        assertTrue(new Float(Float.NaN).equals(new Float(Float.NaN)));
        assertTrue(new Float(Float.NaN).equals(new Float(-Float.NaN)));
    }

    @Test
    public void testFloatCompare() throws Exception {
        // Float.compare calls Float.equal
        assertTrue(Float.compare(-0.0f, 0.0f) < 0);
        // Float.NaN is bigger than any other float values
        assertTrue(Float.compare(Float.NaN, 100.0f) > 0);
        assertTrue(Float.compare(-Float.NaN, 100.0f) > 0);
        assertTrue(Float.compare(Float.NaN, Float.POSITIVE_INFINITY) > 0);
    }

    @Test
    public void testArraysEquals() throws Exception {
        // Arrays.equals calls Float.equal
        float[] ff1 = new float[]{-0.0f};
        float[] ff2 = new float[]{0.0f};
        assertFalse(Arrays.equals(ff1, ff2));
    }
}
