package shuaicj.hello.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * Mock a deadlock.
 *
 * @author shuaicj 2017/01/07
 */
public class DeadLock {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public DeadLock() {
        for (int i = 1;i < 10; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    synchronized (lock1) {
                        synchronized (lock2) {
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
            t.setName("gg" + i);
            t.start();
        }
        for (int i = 1;i < 10; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    synchronized (lock2) {
                        synchronized (lock1) {
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
            t.setName("mm" + i);
            t.start();
        }
    }

}
