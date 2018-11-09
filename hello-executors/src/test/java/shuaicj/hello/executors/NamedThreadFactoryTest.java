package shuaicj.hello.executors;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

import org.junit.Test;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

/**
 * Test spring {@link org.springframework.scheduling.concurrent.CustomizableThreadFactory}
 *
 * @author shuaicj 2017/12/13
 */
public class NamedThreadFactoryTest {

    private final ExecutorService pool = Executors.newSingleThreadExecutor(
            new CustomizableThreadFactory("my-thread-"));

    @Test
    public void test() throws InterruptedException {
        BlockingQueue<String> queue = new SynchronousQueue<>();
        pool.submit(() -> {
            try {
                queue.put(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        String name = queue.take();
        assertThat(name).isEqualTo("my-thread-1");
    }
}
