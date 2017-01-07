package shuaicj.hello.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * Test PreDestroy.
 *
 * @author shuaicj 2017/01/02
 */
@Component
public class HelloDestroyer {

    private static final Logger logger = LoggerFactory.getLogger(HelloDestroyer.class);

    @PreDestroy
    public void destroy() {
        logger.info("This is called @PreDestroy!");
    }
}
