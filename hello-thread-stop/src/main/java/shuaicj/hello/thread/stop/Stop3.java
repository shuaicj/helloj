package shuaicj.hello.thread.stop;

import java.util.concurrent.TimeUnit;

/**
 * The thread won't stop!
 * Only write operation has a synchronized modifier.
 *
 * @author shuaicj 2017/02/21
 */
public class Stop3 {

    private static boolean done;

    private static boolean isDone() {
        return done;
    }

    private static synchronized void setDone(boolean d) {
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

