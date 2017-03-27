package shuaicj.hello.log.jul;

import java.util.logging.Logger;

public class Application {

    private static final Logger logger = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {
        logger.info("Hello Logging");
    }
}
