package shuaicj.hello.command.line.runner.one;

/**
 * Emulate one startup param.
 *
 * @author shuaicj 2017/03/04
 */
public class StartupParam {

    private static String value;

    public static String get() {
        return value;
    }

    public static void set(String value) {
        StartupParam.value = value;
    }
}
