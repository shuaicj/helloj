package shuaicj.hello.executors;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * Test what happens when {@link ScheduledExecutorService}
 * has no thread to allocate for task executions.
 *
 * Conclusion: the task will be queued FIFO until there is an work thread available.
 *
 * See javadoc of {@link java.util.concurrent.ScheduledThreadPoolExecutor}
 *
 * @author shuaicj 2017/12/13
 */
public class ScheduledThreadPoolTest {

    /**
     * These three lines will be printed out immediately (order is not guaranteed):
     *     task executed: 0
     *     task executed: 1
     *     task executed: 2
     *
     * and this line will be printed out after 2 seconds:
     *     task executed: 3
     */
    @Test
    public void test() throws InterruptedException {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
        CountDownLatch latch = new CountDownLatch(4);
        for (int i = 0; i < 4; i++) {
            final int ii = i;
            pool.schedule(() -> {
                try {
                    System.out.println("task executed: " + ii);
                    TimeUnit.SECONDS.sleep(2);
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, ii * 100, TimeUnit.MILLISECONDS);
        }
        latch.await();
    }
}
