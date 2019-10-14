package shuaicj.hello.configuration.case09.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * A foo service.
 *
 * @author shuaicj 2019/10/12
 */
@Service
public class Foo {

    private static final Logger logger = LoggerFactory.getLogger(Foo.class);

    private final String name;

    public Foo() {
        this("default-Foo");
    }

    public Foo(String name) {
        logger.info("create {}", name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
