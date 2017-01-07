package shuaicj.hello.cpu;

/**
 * App entry.
 *
 * @author shuaicj 2017/01/07
 */
public class Application {

    public static void main(String [] args) {
        CPUHelper helper = new CPUHelper();
        System.out.println("cpu num: " + helper.getCPUNumber());
    }
}
