package shuaicj.hello.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test log.
 *
 * @author shuaicj 2017/02/08
 */
public class LogTest {

    @Test
    public void log4j() throws Exception {
        Logger logger = LoggerFactory.getLogger("defaultLogger");
        logger.info("shuaicj.log.nothing");
    }
}
