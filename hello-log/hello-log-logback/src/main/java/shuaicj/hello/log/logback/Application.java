package shuaicj.hello.log.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot app.
 *
 * @author shuaicj 2017/02/22
 */
@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        Marker marker = MarkerFactory.getMarker("tag");

        logger.info(marker, "info in Application");
        logger.debug(marker, "debug in Application");
        // for (int i = 0; i < 100000; i++) {
        //     logger.info("shuaicj.log.bysize {}", i);
        // }
    }
}
