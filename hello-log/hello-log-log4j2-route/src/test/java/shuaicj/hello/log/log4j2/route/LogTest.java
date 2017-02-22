package shuaicj.hello.log.log4j2.route;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test log.
 *
 * @author shuaicj 2017/02/22
 */
public class LogTest {

    private static final Logger logger = LoggerFactory.getLogger("defaultLogger");

    @Test
    public void log4j() throws Exception {
        logger.info("shuaicj.log.nothing");
    }
}
