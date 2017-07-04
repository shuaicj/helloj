package shuaicj.hello.amqp.pubsub.direct.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * The message producer.
 *
 * @author shuaicj 2017/07/04
 */
@Component
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private RabbitTemplate rabbit;

    private int count = 0;

    @Scheduled(fixedDelay = 2000L)
    public void send() {
        String message = "Hello Message " + (count++) + "!";
        if (count % 2 == 0) {
            logger.info("send message q1: {}", message);
            rabbit.convertAndSend(Application.EX, Application.Q1, message);
        } else {
            logger.info("send message q2: {}", message);
            rabbit.convertAndSend(Application.EX, Application.Q2, message);
        }
    }
}
