package shuaicj.hello.maven;

import shuaicj.hello.math.HelloMath;

/**
 * Test configration of maven main class.
 *
 * @author shuaicj 2017/01/10
 */
public class Application {

    public static void main(String[] args) {
        HelloMath math = new HelloMath();
        System.out.println("1 + 2 = " + math.add(1, 2));
    }
}
