package shuaicj.hello.rest.jar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot app.
 *
 * @author shuaicj 2016/12/28
 */
@SpringBootApplication(scanBasePackages = {"shuaicj.hello.rest.jar", "shuaicj.hello.rest.common"})
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
