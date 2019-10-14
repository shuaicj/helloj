package shuaicj.hello.configuration.case10.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class A.
 *
 * @author shuaicj 2019/10/12
 */
public class A {

    private static final Logger logger = LoggerFactory.getLogger(A.class);

    private final String name;

    public A(String name) {
        logger.info("create {}", name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
