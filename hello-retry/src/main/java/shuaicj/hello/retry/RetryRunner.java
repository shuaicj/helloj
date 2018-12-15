package shuaicj.hello.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Run the retry service.
 *
 * @author shuaicj 2018/12/15
 */
@Slf4j
@Component
public class RetryRunner implements ApplicationRunner {

    private final RetryService retryService;

    public RetryRunner(RetryService retryService) {
        this.retryService = retryService;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) {
        log.info("call doWork");
        retryService.doWork();
        log.info("doWork returned");
    }
}
