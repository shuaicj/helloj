package shuaicj.hello.maven.plugin.shade;

import shuaicj.hello.math.HelloMath;

/**
 * Test maven-shade-plugin.
 *
 * @author shuaicj 2017/01/12
 */
public class Application {

    public static void main(String[] args) {
        HelloMath math = new HelloMath();
        System.out.println("This is in " + Application.class.getName() + " and 1 + 2 = " + math.add(1, 2));
    }
}

