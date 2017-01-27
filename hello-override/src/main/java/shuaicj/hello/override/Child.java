package shuaicj.hello.override;

import java.io.IOException;

/**
 * A child class.
 *
 * Conclusions:
 *   1. The access modifier can be more open:
 *         protected in parent -> public in subclass
 *   2. The exception thrown can be more narrow, eg:
 *         throws Exception in parent -> throws IOException in subclass
 *         throws Exception in parent -> no throw in subclass
 *   3. The return type can be more narrow:
 *         return Parent in parent -> return Child in subclass
 *         return Object in parent -> return Integer in subclass
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

    @Override
    public void changeDefaultToPublic() {}

    @Override
    protected void changeDefaultToProtected() {}

    // @Override
    // private void changeDefaultToPrivate() {}

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

    @Override
    public Integer createObject3() {
        return 1;
    }

    @Override
    public void changeExeption1() throws IOException {}

    // @Override
    // public void changeExeption2() throws Exception {}

    @Override
    public void changeExeption3() {}

}
