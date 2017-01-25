package shuaicj.hello.reference;

import org.junit.Test;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test WeakReference.
 *
 * @author shuaicj 2017/01/25
 */
public class WeakReferenceTest {

    private static final class Person {}

    @Test
    @SuppressWarnings("UnusedAssignment")
    public void weakReference() throws Exception {
        Person referent = new Person();
        WeakReference<Person> reference = new WeakReference<>(referent);

        assertThat(reference.get()).isEqualTo(referent);

        referent = null;
        System.gc();
        Thread.sleep(1000);

        // WeakReference does not influence the lifetime of object.
        // WeakReference.get() returns null if the object is recycled by gc.
        assertThat(reference.get()).isNull();
    }

    @Test
    @SuppressWarnings("UnusedAssignment")
    public void weakReferenceWithQueue() throws Exception {
        Person referent = new Person();

        ReferenceQueue<Person> queue = new ReferenceQueue<>();
        WeakReference<Person> reference = new WeakReference<>(referent, queue);

        assertThat(queue.poll()).isNull();
        assertThat(reference.get()).isEqualTo(referent);

        referent = null;
        System.gc();
        Thread.sleep(1000);

        // When the object is recycled by gc, the reference will be in the queue.
        assertThat(queue.poll()).isEqualTo(reference);
        assertThat(reference.get()).isNull();
    }
}
