package shuaicj.hello.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Service with retry.
 *
 * @author shuaicj 2018/12/15
 */
@Slf4j
@Service
public class RetryService {

    private final AtomicInteger counter = new AtomicInteger();

    @Retryable(maxAttempts = 100, backoff = @Backoff(delay = 2000))
    public void doWork() {
        int count = counter.incrementAndGet();
        log.info("count {}: doWork", count);
        if (count < 3) {
            throw new RuntimeException("shit happens " + count);
        }
    }
}
