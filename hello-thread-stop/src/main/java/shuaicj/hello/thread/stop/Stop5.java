package shuaicj.hello.thread.stop;

import java.util.concurrent.TimeUnit;

/**
 * The thread will stop.
 * The variable has a volatile modifier.
 *
 * @author shuaicj 2017/02/21
 */
public class Stop5 {

    private static volatile boolean done;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            //noinspection StatementWithEmptyBody
            while (!done) {}
            System.out.println("Thread stopped!");
        }).start();

        TimeUnit.SECONDS.sleep(1);
        done = true;
    }
}

