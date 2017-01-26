package shuaicj.hello.override;

/**
 * A child class.
 *
 * @author shuaicj 2017/01/26
 */
@SuppressWarnings("unused")
public class Child extends Parent {

    // @Override
    // protected void changePublicToProtected() {}

    // @Override
    // private void changePublicToPrivate() {}

    // @Override
    // void changePublicToDefault() {}

    @Override
    public void changeProtectedToPublic() {}

    // @Override
    // private void changeProtectedToPrivate() {}

    // @Override
    // void changeProtectedToDefault() {}

    // @Override
    public void changePrivateToPublic() {}

    // @Override
    protected void changePrivateToProtected() {}

    // @Override
    void changePrivateToDefault() {}

    @Override
    public Parent createObject1() {
        return new Parent();
    }

    @Override
    public Child createObject2() {
        return new Child();
    }
}
