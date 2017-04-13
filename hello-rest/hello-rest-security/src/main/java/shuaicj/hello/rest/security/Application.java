package shuaicj.hello.rest.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot app.
 *
 * @author shuaicj 2016/12/28
 */
@SpringBootApplication(scanBasePackages = {"shuaicj.hello.rest.security", "shuaicj.hello.rest.basic"})
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
