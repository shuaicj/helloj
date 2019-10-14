package shuaicj.hello.configuration.case11.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class A.
 *
 * @author shuaicj 2019/10/12
 */
public class B {

    private static final Logger logger = LoggerFactory.getLogger(B.class);

    private final String name;

    public B(String name) {
        logger.info("create {}", name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
