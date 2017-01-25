package shuaicj.hello.reference;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test StrongReference.
 *
 * @author shuaicj 2017/01/25
 */
public class StrongReferenceTest {

    private static final class Person {}

    @Test
    @SuppressWarnings("UnusedAssignment")
    public void strongReference() throws Exception {
        Person referent = new Person();
        Person reference = referent;

        assertThat(reference).isEqualTo(referent);

        referent = null;
        System.gc();
        Thread.sleep(1000);

        // Only if there is no string reference, the object can be recycled by gc.
        assertThat(reference).isNotNull();
    }
}
