package shuaicj.hello.amqp.pubsub.fanout.consumer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
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

    static final String EX = "hello-ex-fanout";
    static final String Q1 = "hello-q1-fanout";
    static final String Q2 = "hello-q2-fanout";

    @Bean
    FanoutExchange exchange() {
        return new FanoutExchange(EX);
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
        return BindingBuilder.bind(queue1()).to(exchange());
    }

    @Bean
    Binding binding2() {
        return BindingBuilder.bind(queue2()).to(exchange());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
