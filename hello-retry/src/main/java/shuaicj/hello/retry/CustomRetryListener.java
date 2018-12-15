package shuaicj.hello.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.listener.RetryListenerSupport;
import org.springframework.stereotype.Component;

/**
 * Log messages when retry happens.
 *
 * @author shuaicj 2018/12/15
 */
@Slf4j
@Component
public class CustomRetryListener extends RetryListenerSupport {

    @Override
    public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback,
                                                 Throwable throwable) {
        Object name = context.getAttribute(RetryContext.NAME);
        int count = context.getRetryCount();
        log.info("{} {} {}", count, name, throwable.getMessage());
    }
}
