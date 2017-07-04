package shuaicj.hello.amqp.pubsub.fanout.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * The message producer.
 *
 * @author shuaicj 2017/07/04
 */
@Component
@RabbitListener(queues = Application.Q1)
public class Consumer1 {

    private static final Logger logger = LoggerFactory.getLogger(Consumer1.class);

    @RabbitHandler
    public void receive(String message) {
        logger.info("Consumer1 receive message: {}", message);
    }
}
