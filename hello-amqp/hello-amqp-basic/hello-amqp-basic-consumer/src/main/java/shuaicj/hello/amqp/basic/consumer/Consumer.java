package shuaicj.hello.amqp.basic.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * The message producer.
 *
 * @author shuaicj 2017/06/26
 */
@Component
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues = Application.Q)
    public void receive(String message) {
        logger.info("receive message: {}", message);
    }
}
