package shuaicj.hello.amqp.pubsub.topic.producer;

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
        String message = "Hello Message " + count + "!";
        int num = 7;
        if (count % num == 0) {
            logger.info("send message q1: {}", message);
            rabbit.convertAndSend(Application.EX, "shuaicj.xxx.zzz", message);
        } else if (count % num == 1) {
            logger.info("send message q2: {}", message);
            rabbit.convertAndSend(Application.EX, "xxx.hello.zzz", message);
        } else if (count % num == 2) {
            logger.info("send message q3: {}", message);
            rabbit.convertAndSend(Application.EX, "xxx.zzz.amqp", message);
        } else if (count % num == 3) {
            logger.info("send message q1,q2: {}", message);
            rabbit.convertAndSend(Application.EX, "shuaicj.hello.xxx", message);
        } else if (count % num == 4) {
            logger.info("send message q1,q3: {}", message);
            rabbit.convertAndSend(Application.EX, "shuaicj.xxx.amqp", message);
        } else if (count % num == 5) {
            logger.info("send message q2,q3: {}", message);
            rabbit.convertAndSend(Application.EX, "xxx.hello.amqp", message);
        } else {
            logger.info("send message q1,q2,q3: {}", message);
            rabbit.convertAndSend(Application.EX, "shuaicj.hello.amqp", message);
        }
        count++;
    }
}
