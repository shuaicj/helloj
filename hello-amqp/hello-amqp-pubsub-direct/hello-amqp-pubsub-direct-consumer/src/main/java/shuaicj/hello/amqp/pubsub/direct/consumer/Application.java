package shuaicj.hello.amqp.pubsub.direct.consumer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Spring boot app.
 *
 * @author shuaicj 2017/07/04
 */
@SpringBootApplication
public class Application {

    static final String EX = "hello-direct-ex";
    static final String Q1 = "hello-direct-q1";
    static final String Q2 = "hello-direct-q2";

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(EX);
    }

    @Bean
    Queue queue1() {
        return new Queue(Q1);
    }

    @Bean
    Queue queue2() {
        return new Queue(Q2);
    }

    @Bean
    Binding binding1() {
        return BindingBuilder.bind(queue1()).to(exchange()).with(Q1);
    }

    @Bean
    Binding binding2() {
        return BindingBuilder.bind(queue2()).to(exchange()).with(Q2);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
