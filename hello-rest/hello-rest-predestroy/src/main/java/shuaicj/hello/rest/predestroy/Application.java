package shuaicj.hello.rest.predestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot app.
 *
 * @author shuaicj 2016/12/28
 */
@SpringBootApplication(scanBasePackages = {"shuaicj.hello.rest.predestroy", "shuaicj.hello.rest.basic"})
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
