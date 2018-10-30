package shuaicj.hello.mockito;

/**
 * A class to help the test.
 *
 * @author shuaicj 2018/10/30
 */
public class User {

    public static final String ANONYMOUS = "anonymous";

    private final String name;

    public User() {
        this(ANONYMOUS);
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public final String getNameFinal() {
        return name;
    }

    public static String getNameStatic(String name) {
        return name;
    }

    public String getNamePrivateProxy() {
        return this.getNamePrivate();
    }

    private String getNamePrivate() {
        return name;
    }
}
