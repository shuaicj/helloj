package shuaicj.hello.exception.uncaught;

import java.util.concurrent.TimeUnit;

/**
 * Test uncaught exception handler.
 *
 * @author shuaicj 2017/04/12
 */
public class Application {

    public static void main(String[] args) {
        System.out.println("main thread name: " + Thread.currentThread().getName());
        try {
            Thread t = new Thread(() -> {
                System.out.println("sub thread name: " + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("in sub thread - interrupt: " + e);
                }
                throw new IllegalArgumentException("in sub thread - run");
            });
            t.setUncaughtExceptionHandler((tt, e) -> {
                throw new RuntimeException("in sub thread - caught", e);
            });
            t.start();
        } catch (Exception e) {
            System.out.println("in main thread - catch: " + e);
        }
    }
}
