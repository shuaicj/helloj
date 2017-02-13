package shuaicj.hello.persist.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Spring boot application.
 *
 * @author shuaicj 2017/02/13
 */
@SpringBootApplication(scanBasePackages = {"shuaicj.hello.persist.cache", "shuaicj.hello.persist.jdbc.template"})
@EnableCaching
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

