package shuaicj.hello.thread.stop;

import java.util.concurrent.TimeUnit;

/**
 * The thread will stop.
 * Only read operation has a synchronized modifier.
 *
 * @author shuaicj 2017/02/21
 */
public class Stop4 {

    private static boolean done;

    private static synchronized boolean isDone() {
        return done;
    }

    private static void setDone(boolean d) {
        done = d;
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            //noinspection StatementWithEmptyBody
            while (!isDone()) {}
            System.out.println("Thread stopped!");
        }).start();

        TimeUnit.SECONDS.sleep(1);
        setDone(true);
    }
}
