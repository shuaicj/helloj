package shuaicj.hello.command.line.runner.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Emulate some startup params.
 *
 * @author shuaicj 2017/03/04
 */
public class StartupParams {

    private static List<String> params = new ArrayList<>();

    public static List<String> get() {
        return Collections.unmodifiableList(params);
    }

    public static void add(String param) {
        params.add(param);
    }
}
