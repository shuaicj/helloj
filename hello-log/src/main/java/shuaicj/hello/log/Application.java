package shuaicj.hello.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Application entry.
 *
 * @author shuaicj 2017/02/08
 */
public class Application {

    public static void main(String[] args) {
        Logger logger = LogManager.getRootLogger();
        logger.info("shuaicj.log.default");

        System.setProperty("shuaicj.log.rolling", "rollingByDate");
        System.setProperty("shuaicj.log.path", "bydate.log");
        logger.info("shuaicj.log.bydate");

        System.setProperty("shuaicj.log.rolling", "rollingBySize");
        System.setProperty("shuaicj.log.path", "bysize.log");
        System.setProperty("shuaicj.log.size", "1");
        System.setProperty("shuaicj.log.max", "3");
        for (int i = 0; i < 5000000; i++) {
            logger.info("shuaicj.log.bysize");
        }
    }
}

