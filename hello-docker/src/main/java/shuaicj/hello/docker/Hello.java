package shuaicj.hello.docker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A java bean representing a greeting.
 *
 * @author shuaicj 2017/04/10
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hello {

    private long id;
    private String content;
}

