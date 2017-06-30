package shuaicj.hello.amqp.message.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import shuaicj.hello.amqp.message.common.Message;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The message producer.
 *
 * @author shuaicj 2017/06/30
 */
@Component
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private RabbitTemplate rabbit;

    private final AtomicInteger count = new AtomicInteger();

    @Scheduled(fixedDelay = 2000L)
    public void sendString() {
        String message = "Hello Message " + count.incrementAndGet() + "!";
        logger.info("send string message: {}", message);
        rabbit.convertAndSend(Application.Q, message);
    }

    @Scheduled(fixedDelay = 2000L)
    public void sendObject() {
        int c = count.incrementAndGet();
        Message message = new Message("id-" + c, "content-" + c);
        logger.info("send object message: {}", message);
        rabbit.convertAndSend(Application.Q, message);
    }
}
