package shuaicj.hello.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * A scheduled task via Spring Boot.
 *
 * @author shuaicj 2017/01/08
 */
@Component
public class ScheduledTask {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 2000)
    public void reportCurrentTime() {
        // check the thread name in logging messages
        logger.info("The time is now " + dateFormat.format(new Date()));
    }
}
