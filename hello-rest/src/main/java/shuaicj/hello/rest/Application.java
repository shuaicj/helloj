package shuaicj.hello.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Description.
 *
 * @author shuaicj 2016/12/28
 */
@SpringBootApplication
public class Application  extends SpringBootServletInitializer {

    // for spring boot packaging: war
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
