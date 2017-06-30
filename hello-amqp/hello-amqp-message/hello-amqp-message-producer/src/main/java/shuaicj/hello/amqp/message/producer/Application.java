package shuaicj.hello.amqp.message.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Spring boot app.
 *
 * @author shuaicj 2017/06/30
 */
@SpringBootApplication
@EnableScheduling
public class Application {

    static final String Q = "hello-q-message";

    @Bean
    Queue queue() {
        return new Queue(Q);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
