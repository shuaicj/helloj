package shuaicj.hello.cpu;

/**
 * A helper to get the cpu core number.
 *
 * @author shuaicj 2017/01/07
 */
public class CPUHelper {

    public int getCPUNumber() {
        return Runtime.getRuntime().availableProcessors();
    }
}
