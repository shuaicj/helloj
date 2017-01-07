package shuaicj.hello.math;

/**
 * Description.
 *
 * @author shuaicj 2016/12/28
 */
public class HelloMath {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public double sqrt(double v, double offset) throws IllegalArgumentException {
        if (v <= 1 || offset <= 0 || offset >= 1) {
            throw new IllegalArgumentException();
        }
        double start = 0, end = v;
        double mid;
        while (true) {
            mid = (start + end) / 2;
            if ((mid - offset) * (mid - offset) < v && (mid + offset) * (mid + offset) > v) {
                return mid;
            } else if (mid * mid < v) {
                start = mid;
            } else {
                end = mid;
            }
        }
    }

}
