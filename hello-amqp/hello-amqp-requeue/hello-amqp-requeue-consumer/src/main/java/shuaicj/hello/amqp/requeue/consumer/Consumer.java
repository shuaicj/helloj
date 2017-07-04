package shuaicj.hello.amqp.requeue.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * The message producer.
 *
 * @author shuaicj 2017/07/04
 */
@Component
@RabbitListener(queues = Application.Q)
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @RabbitHandler
    public void receive(String message) throws Exception {
        double r = Math.random();
        if (r < 0.1) {
            logger.info("rejectAndNotRequeue message: {}", message);
            // throw this exception if you need rejectAndNotRequeue
            throw new AmqpRejectAndDontRequeueException("rejectAndNotRequeue " + message);
        } else if (r < 0.2) {
            logger.info("rejectAndRequeue message: {}", message);
            // throw any other exception if you need rejectAndRequeue
            throw new Exception("rejectAndRequeue " + message);
        } else {
            logger.info("receive message: {}", message);
            // nothing thrown means the message is consumed successfully
        }
    }
}
