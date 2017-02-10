package shuaicj.hello.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * Application entry.
 *
 * @author shuaicj 2017/02/08
 */
public class Application {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("logger.error.xxx");
        logger.info("shuaicj.log.default");

        MDC.put("shuaicj.log.rolling", "byDate");
        MDC.put("shuaicj.log.path", "bydate.log");
        logger.debug("shuaicj.log.bydate");

        MDC.put("shuaicj.log.rolling", "bySize");
        MDC.put("shuaicj.log.path", "bysize.log");
        MDC.put("shuaicj.log.size", "1");
        MDC.put("shuaicj.log.max", "3");
        logger.warn("shuaicj.log.bysize");
        // for (int i = 0; i < 1000000; i++) {
        //     logger.info("shuaicj.log.bysize {}", i);
        // }
    }
}

