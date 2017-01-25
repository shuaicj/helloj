package shuaicj.hello.reference;

import org.junit.Test;

import java.util.WeakHashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test WeakHashMap.
 *
 * @author shuaicj 2017/01/25
 */
public class TestWeakHashMap {

    private static final class Person {}

    @Test
    @SuppressWarnings("UnusedAssignment")
    public void test() throws Exception {
        WeakHashMap<Person, Object> map = new WeakHashMap<>();
        Person k = new Person();
        Object v = new Object();
        map.put(k, v);

        assertTrue(map.containsKey(k));
        assertTrue(map.containsValue(v));

        k = null;
        System.gc();
        Thread.sleep(1000);

        // WeakHashMap uses WeakReference as key.
        // When the key is recycled by gc, WeakHashMap clears it's corresponding MapEntry automatically.
        assertFalse(map.containsValue(v));
    }
}
