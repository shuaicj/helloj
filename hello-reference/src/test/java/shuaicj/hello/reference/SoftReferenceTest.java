package shuaicj.hello.reference;

import org.junit.Test;

import java.lang.ref.SoftReference;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test SoftReference.
 *
 * @author shuaicj 2017/01/25
 */
public class SoftReferenceTest {

    private static final class Person {}

    @Test
    @SuppressWarnings("UnusedAssignment")
    public void softReference() throws Exception {
        Person referent = new Person();
        SoftReference<Person> reference = new SoftReference<>(referent);

        assertThat(reference.get()).isEqualTo(referent);

        referent = null;
        System.gc();
        Thread.sleep(1000);

        // Only if jvm is going to be out of memory, the object can be recycled by gc and
        // SoftReference.get() will return null then.
        assertThat(reference.get()).isNotNull();
    }
}
