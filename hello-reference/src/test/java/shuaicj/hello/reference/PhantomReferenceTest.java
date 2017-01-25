package shuaicj.hello.reference;

import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test PhantomReference.
 *
 * @author shuaicj 2017/01/25
 */
public class PhantomReferenceTest {

    private static final class Person {}

    @Test
    @SuppressWarnings("UnusedAssignment")
    public void phantomReference() throws Exception {
        Person referent = new Person();

        ReferenceQueue<Person> queue = new ReferenceQueue<>();
        PhantomReference<Person> reference = new PhantomReference<>(referent, queue);

        assertThat(queue.poll()).isNull();
        assertThat(reference.get()).isNull();

        referent = null;
        System.gc();
        Thread.sleep(1000);

        // PhantomReference.get() returns null always.
        // With the help of a ReferenceQueue, PhantomReference can be used to track when an object is recycled.
        // When the object is recycled by gc, the reference will be in the queue.
        assertThat(queue.poll()).isEqualTo(reference);
        assertThat(reference.get()).isNull();
    }
}
