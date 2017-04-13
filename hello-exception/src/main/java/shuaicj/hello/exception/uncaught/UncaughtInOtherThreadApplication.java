package shuaicj.hello.exception.uncaught;

import java.util.concurrent.TimeUnit;

/**
 * Test uncaught exception in other thread.
 *
 * Conclusion:
 *   1. Thread.setUncaughtExceptionHandler() cannot catch the exception in other threads.
 *   2. The crash of a thread won't affect the execution of other threads.
 *
 * @author shuaicj 2017/04/13
 */
public class UncaughtInOtherThreadApplication {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread name: " + Thread.currentThread().getName());
        Thread.currentThread().setUncaughtExceptionHandler(
                (tt, e) -> System.out.println("in main thread uncaught - " + e));

        new Thread(() -> {
            System.out.println("new thread name: " + Thread.currentThread().getName());
            throw new RuntimeException("in new thread run");
        }).start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("main thread exit");
    }
}
