package shuaicj.hello.log.log4j2;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test log.
 *
 * @author shuaicj 2017/02/22
 */
public class LogTest {

    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void logback() throws Exception {
        logger.info("info in LogTest");
        logger.debug("debug in LogTest");
    }
}
