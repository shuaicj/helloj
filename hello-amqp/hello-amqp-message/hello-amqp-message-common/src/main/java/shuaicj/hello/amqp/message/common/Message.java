package shuaicj.hello.amqp.message.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * A simple message.
 *
 * @author shuaicj 2017/06/30
 */
@Getter
@AllArgsConstructor
@ToString
@SuppressWarnings("serial")
public class Message implements Serializable {

    private String id;
    private String content;
}
