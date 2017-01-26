package shuaicj.hello.override;

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

    private void changePrivateToPublic() {}

    private void changePrivateToProtected() {}

    private void changePrivateToDefault() {}

    public Parent createObject1() {
        return new Parent();
    }

    public Parent createObject2() {
        return new Parent();
    }
}
