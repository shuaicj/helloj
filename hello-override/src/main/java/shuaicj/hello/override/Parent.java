package shuaicj.hello.override;

import java.io.IOException;

/**
 * A parent class.
 *
 * @author shuaicj 2017/01/26
 */
@SuppressWarnings("unused")
public class Parent {

    public void changePublicToProtected() {}

    public void changePublicToPrivate() {}

    public void changePublicToDefault() {}

    protected void changeProtectedToPublic() {}

    protected void changeProtectedToPrivate() {}

    protected void changeProtectedToDefault() {}

    void changeDefaultToPublic() {}

    void changeDefaultToProtected() {}

    void changeDefaultToPrivate() {}

    private void changePrivateToPublic() {}

    private void changePrivateToProtected() {}

    private void changePrivateToDefault() {}

    public Parent createObject1() {
        return new Parent();
    }

    public Parent createObject2() {
        return new Parent();
    }

    public Object createObject3() {
        return new Object();
    }

    public void changeExeption1() throws Exception {}

    public void changeExeption2() throws IOException {}

    public void changeExeption3() throws Exception {}
}
