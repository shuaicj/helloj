package shuaicj.hello.log.jcl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Application {

    private static final Log logger = LogFactory.getLog(Application.class);

    public static void main(String[] args) {
        logger.info("Hello Logging");
    }
}
