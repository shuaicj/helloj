package shuaicj.hello.persist.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot application.
 *
 * @author shuaicj 2017/02/03
 */
@SpringBootApplication(scanBasePackages = {"shuaicj.hello.persist.transaction", "shuaicj.hello.persist.jdbc.template"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

