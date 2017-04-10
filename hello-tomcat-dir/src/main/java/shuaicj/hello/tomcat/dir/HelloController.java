package shuaicj.hello.tomcat.dir;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple spring boot rest controller.
 *
 * @author shuaicj 2017/04/10
 */
@RestController
public class HelloController {

    @Value("${java.io.tmpdir}")
    private String tmpdir;

    @GetMapping("/hello")
    public String hello() {
        return "tomcat embedded default work dir: " + tmpdir;
    }
}

