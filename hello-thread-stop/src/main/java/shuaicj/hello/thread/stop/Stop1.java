package shuaicj.hello.thread.stop;

import java.util.concurrent.TimeUnit;

/**
 * The thread won't stop!
 *
 * while(!done) {}
 * will be optimized as:
 * if (!done) {
 *     while(true) {}
 * }
 *
 * @author shuaicj 2017/02/21
 */
public class Stop1 {

    private static boolean done;

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
