package shuaicj.hello.enumtest.abcde;

/**
 * An enum representing A, B, C, D, E.
 *
 * @author shuaicj 2017/02/05
 */
public enum ABCDE {

    A("a"),
    B("b"),
    C("c"),
    D("d"),
    E("e");

    private String lowerCase;

    ABCDE(String lowerCase) {
        this.lowerCase = lowerCase;
    }

    public String getLowerCase() {
        return lowerCase;
    }
}
