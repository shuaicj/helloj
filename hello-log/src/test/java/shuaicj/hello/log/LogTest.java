package shuaicj.hello.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Test log.
 *
 * @author shuaicj 2017/02/08
 */
public class LogTest {

    @Test
    public void log4j() throws Exception {
        Logger logger = LogManager.getLogger();
        logger.info("shuaicj.log.nothing");
    }
}
