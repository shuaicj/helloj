package shuaicj.hello.configuration.case13.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class A.
 *
 * @author shuaicj 2019/10/12
 */
public class C {

    private static final Logger logger = LoggerFactory.getLogger(C.class);

    private final String name;

    public C(String name) {
        logger.info("create {}", name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
