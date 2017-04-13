package shuaicj.hello.exception.uncaught;

import java.util.concurrent.TimeUnit;

/**
 * Test uncaught exception in try catch block.
 *
 * Conclusion:
 *   Try-Catch block cannot catch the exception in other threads.
 *
 * @author shuaicj 2017/04/13
 */
public class UncaughtTryCatchApplication {

    public static void main(String[] args) {
        System.out.println("main thread name: " + Thread.currentThread().getName());
        try {
            new Thread(() -> {
                System.out.println("new thread name: " + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("in new thread interrupt - " + e);
                }
                throw new RuntimeException("in new thread run");
            }).start();
        } catch (Exception e) {
            System.out.println("in main thread - catch: " + e);
        }
        System.out.println("main thread exit");
    }
}
