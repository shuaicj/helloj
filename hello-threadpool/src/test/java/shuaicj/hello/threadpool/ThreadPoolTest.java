package shuaicj.hello.threadpool;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test ThreadPool.
 *
 * @author shuaicj 2017/02/04
 */
public class ThreadPoolTest {

    private ExecutorService pool = Executors.newFixedThreadPool(5);

    @SuppressWarnings("Convert2Lambda")
    @Test
    public void addRunnable() throws Exception {
        pool.submit(new Runnable() {
            @Override
            public void run() {
                // do things here
            }
        });
    }

    @Test
    public void addLambdaRunnable() throws Exception {
        pool.submit(() -> {
            // do things here
        });
    }

    @SuppressWarnings("Convert2Lambda")
    @Test
    public void addRunnableWithResult() throws Exception  {
        Future<String> result = pool.submit(new Runnable() {
            @Override
            public void run() {
                // do things here
            }
        }, "abcd");
        assertThat(result.get()).isEqualTo("abcd");
    }

    @Test
    public void addLambdaRunnableWithResult() throws Exception  {
        Future<String> result = pool.submit(() -> {
            // do things here
        }, "abcd");
        assertThat(result.get()).isEqualTo("abcd");
    }

    @SuppressWarnings("Convert2Lambda")
    @Test
    public void addCallable() throws Exception  {
        Future<String> result = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "abcd";
            }
        });
        assertThat(result.get()).isEqualTo("abcd");
    }

    @Test
    public void addLambdaCallable() throws Exception  {
        Future<String> result = pool.submit(() -> "abcd");
        assertThat(result.get()).isEqualTo("abcd");
    }

    @SuppressWarnings("Convert2Lambda")
    @Test
    public void addCallableVoid() throws Exception  {
        Future<Void> result = pool.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                return null;
            }
        });
        assertThat(result.get()).isNull();
    }

    @Test
    public void addLambdaCallableVoid() throws Exception  {
        Future<Void> result = pool.submit(() -> null);
        assertThat(result.get()).isNull();
    }
}
