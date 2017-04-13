package shuaicj.hello.rest.basic;

/**
 * A java bean representing a greeting.
 *
 * @author shuaicj 2016/12/28
 */
public class Hello {

    private long id;
    private String content;

    public Hello() {}

    public Hello(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}

