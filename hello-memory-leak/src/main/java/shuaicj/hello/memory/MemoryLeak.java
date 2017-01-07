package shuaicj.hello.memory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Mock a memory leak.
 *
 * @author shuaicj 2017/01/07
 */
public class MemoryLeak {

    List<List<Integer>> list = new LinkedList<>();

    public MemoryLeak() {
        new Thread(() -> {
            while (true) {
                list.add(new ArrayList<>(64));
                System.out.println("leak 64");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
