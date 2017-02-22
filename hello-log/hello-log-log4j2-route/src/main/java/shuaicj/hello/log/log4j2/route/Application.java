package shuaicj.hello.log.log4j2.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot app.
 *
 * @author shuaicj 2017/02/22
 */
@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger("logger.info.xxx");

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        logger.debug("shuaicj.log.default");
        logger.info("shuaicj.log.default");
        logger.warn("shuaicj.log.default");

        MDC.put("shuaicj.log.rolling", "byDate");
        MDC.put("shuaicj.log.path", "bydate.log");
        logger.debug("shuaicj.log.bydate");
        logger.info("shuaicj.log.bydate");
        logger.warn("shuaicj.log.bydate");

        MDC.put("shuaicj.log.rolling", "bySize");
        MDC.put("shuaicj.log.path", "bysize.log");
        MDC.put("shuaicj.log.size", "1");
        MDC.put("shuaicj.log.max", "3");
        logger.debug("shuaicj.log.bysize");
        logger.info("shuaicj.log.bysize");
        logger.warn("shuaicj.log.bysize");
        // for (int i = 0; i < 1000000; i++) {
        //     logger.info("shuaicj.log.bysize {}", i);
        // }
    }
}

