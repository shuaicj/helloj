package shuaicj.hello.varargs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test varargs ...
 * Varargs is implemented as array internally.
 *
 * @author shuaicj 2017/05/09
 */
@SuppressWarnings({"ManualArrayToCollectionCopy", "ForLoopReplaceableByForEach", "UseBulkOperation"})
public class VarargsTest {

    @Test
    public void access() {
        assertThat(asList1("aa", "b", "ccc")).containsExactly("aa", "b", "ccc");
        assertThat(asList2("aa", "b", "ccc")).containsExactly("aa", "b", "ccc");
    }

    @Test
    public void empty() {
        assertThat(asList1()).hasSize(0);
        assertThat(asList2()).hasSize(0);
    }

    @Test
    public void index() {
        assertThat(getSecond("aa", "b", "ccc")).isEqualTo("b");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void indexOutOfBounds() {
        getSecond("aa");
    }

    @Test
    public void passInArrayWhereNeedVarargs() {
        assertThat(asList1(new String[]{"aa", "b", "ccc"})).containsExactly("aa", "b", "ccc");
    }

    @Test
    public void passInVarargsWhereNeedArray() {
        assertThat(asList3("aa", "b", "ccc")).containsExactly("aa", "b", "ccc");
    }

    @Test
    public void generics() {
        assertThat(asList4("aa", "b", "ccc")).containsExactly("aa", "b", "ccc");
    }

    @Test
    public void prior() {
        assertThat(asList5("aa", "b")).containsExactly("I am prior to varargs", "aa", "b");
    }

    @Test
    public void ambiguousArgNum() {
        // asList6("aa", "b");
    }

    @Test
    public void ambiguousAutoBoxing() {
        // asList7(5, 6);
        // asList7(Integer.valueOf(5), Integer.valueOf(6));
    }

    private static List<String> asList1(String... ss) {
        List<String> list = new ArrayList<>(ss.length);
        for (int i = 0; i < ss.length; i++) {
            list.add(ss[i]);
        }
        return list;
    }

    /**
     * This method causes compile error because varargs is implemented as array.
     */
    // private static List<String> asList1(String[] ss) {
    //     List<String> list = new ArrayList<>(ss.length);
    //     for (int i = 0; i < ss.length; i++) {
    //         list.add(ss[i]);
    //     }
    //     return list;
    // }

    private static List<String> asList2(String... ss) {
        List<String> list = new ArrayList<>(ss.length);
        for (String s : ss) {
            list.add(s);
        }
        return list;
    }

    private static List<String> asList3(String... ss) {
        return array2List(ss);
    }

    /**
     * refer to 'heap pollution from parameterized vararg'
     * https://docs.oracle.com/javase/tutorial/java/generics/nonReifiableVarargsType.html#heap_pollution
     */
    @SafeVarargs
    private static <T> List<T> asList4(T... ss) {
        List<T> list = new ArrayList<>(ss.length);
        for (T s : ss) {
            list.add(s);
        }
        return list;
    }

    /**
     * The method with fixed number of args is prior to the one with varargs.
     */
    private static List<String> asList5(String s0, String s1) {
        return Arrays.asList("I am prior to varargs", s0, s1);
    }

    @SuppressWarnings("unused")
    private static List<String> asList6(String... ss) {
        return asList1(ss);
    }

    @SuppressWarnings("unused")
    private static List<String> asList6(String s0, String... ss) {
        List<String> list = asList1(ss);
        list.add(s0);
        return list;
    }

    @SuppressWarnings("unused")
    private static List<Integer> asList7(int... ss) {
        List<Integer> list = new ArrayList<>(ss.length);
        for (int s : ss) {
            list.add(s);
        }
        return list;
    }

    @SuppressWarnings("unused")
    private static List<Integer> asList7(Integer... ss) {
        List<Integer> list = new ArrayList<>(ss.length);
        for (Integer s : ss) {
            list.add(s);
        }
        return list;
    }

    private static List<String> array2List(String[] ss) {
        List<String> list = new ArrayList<>(ss.length);
        for (String s : ss) {
            list.add(s);
        }
        return list;
    }

    private static String getSecond(String... ss) {
        return ss[1];
    }
}
