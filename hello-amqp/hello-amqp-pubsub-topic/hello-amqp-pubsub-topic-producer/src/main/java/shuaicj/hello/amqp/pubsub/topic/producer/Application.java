package shuaicj.hello.amqp.pubsub.topic.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Spring boot app.
 *
 * @author shuaicj 2017/07/04
 */
@SpringBootApplication
@EnableScheduling
public class Application {

    static final String EX = "hello-ex-topic";
    static final String Q1 = "hello-q1-topic";
    static final String Q2 = "hello-q2-topic";
    static final String Q3 = "hello-q3-topic";

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EX);
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
    Queue queue3() {
        return new Queue(Q3);
    }

    @Bean
    Binding binding1() {
        return BindingBuilder.bind(queue1()).to(exchange()).with("shuaicj.#");
    }

    @Bean
    Binding binding2() {
        return BindingBuilder.bind(queue2()).to(exchange()).with("*.hello.*");
    }

    @Bean
    Binding binding3() {
        return BindingBuilder.bind(queue3()).to(exchange()).with("*.*.amqp");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
