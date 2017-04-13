package shuaicj.hello.exception.uncaught;

/**
 * Test uncaught exception in self thread.
 *
 * Conclusion:
 *   Thread.setUncaughtExceptionHandler() can catch the exception in self thread.
 *
 * @author shuaicj 2017/04/13
 */
public class UncaughtApplication {

    public static void main(String[] args) {
        System.out.println("main thread name: " + Thread.currentThread().getName());
        Thread t = new Thread(() -> {
            System.out.println("new thread name: " + Thread.currentThread().getName());
            throw new RuntimeException("in new thread run");
        });
        t.setUncaughtExceptionHandler((tt, e) -> System.out.println("in new thread uncaught - " + e));
        t.start();
    }
}
