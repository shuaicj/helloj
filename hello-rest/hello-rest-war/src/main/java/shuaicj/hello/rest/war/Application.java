package shuaicj.hello.rest.war;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Spring boot app.
 *
 * @author shuaicj 2016/12/28
 */
@SpringBootApplication(scanBasePackages = {"shuaicj.hello.rest.war", "shuaicj.hello.rest.basic"})
public class Application extends SpringBootServletInitializer {

    // for spring boot packaging: war
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
