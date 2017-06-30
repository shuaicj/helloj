package shuaicj.hello.amqp.message.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import shuaicj.hello.amqp.message.common.Message;

/**
 * The message producer.
 *
 * @author shuaicj 2017/06/30
 */
@Component
@RabbitListener(queues = Application.Q)
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @RabbitHandler
    public void receive(String message) {
        logger.info("receive string message: {}", message);
    }

    @RabbitHandler
    public void receive(Message message) {
        logger.info("receive object message: {}", message);
    }
}
