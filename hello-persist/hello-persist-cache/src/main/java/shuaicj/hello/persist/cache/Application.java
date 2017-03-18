package shuaicj.hello.persist.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring boot application.
 *
 * @author shuaicj 2017/02/13
 */
@SpringBootApplication
@EnableJpaRepositories("shuaicj.hello.persist.jpa")
@EntityScan("shuaicj.hello.persist.jpa")
@EnableJpaAuditing
@EnableCaching
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

