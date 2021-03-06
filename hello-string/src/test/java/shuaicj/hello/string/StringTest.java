package shuaicj.hello.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test String.
 *
 * Conclusions:
 *   1. Literal Strings are always in the pool.
 *   2. Strings by 'new String(..)' are not in the pool.
 *   3. Strings by 'String.intern()' are always in the pool.
 *   4. Strings by 'String.valueOf(..)' are not in the pool.
 *   5. Strings by 'StringBuilder.toString()' are not in the pool.
 *   6. Strings by 'literal append' are always in the pool because of compiler optimization.
 *   7. Strings by 'variable append' are not in the pool because it's done via StringBuilder.
 *
 *   8. String.valueOf(char[]) and String.valueOf(Object) act weird while passing in the same char[].
 *
 * @author shuaicj 2017/02/05
 */
@SuppressWarnings({"RedundantStringConstructorCall", "StringEquality"})
public class StringTest {

    @Test
    public void literal() throws Exception {
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = "abc";
        assertTrue(s1 != s2);
        assertTrue(s1 == s3);
    }

    @Test
    public void intern() throws Exception {
        String s1 = "abc";
        String s2 = s1.intern();
        String s3 = new String("abc");
        String s4 = s3.intern();
        assertTrue(s1 == s2);
        assertTrue(s3 != s4);
        assertTrue(s3 != s1);
        assertTrue(s4 == s1);
        String s5 = new String("def");
        String s6 = s5.intern();
        String s7 = "def";
        assertTrue(s5 != s6);
        assertTrue(s5 != s7);
        assertTrue(s6 == s7);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void valueOf() throws Exception {
        String s1 = "123";
        String s2 = String.valueOf(123);
        String s3 = s2.intern();
        assertTrue(s1 != s2);
        assertTrue(s1 == s3);
        assertTrue(s2 != s3);
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    @Test
    public void builder() throws Exception {
        String s1 = "abc";
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("b");
        sb.append("c");
        String s2 = sb.toString();
        assertTrue(s1.equals(s2));
        assertTrue(s1 != s2);
    }

    @Test
    public void literalAppend() throws Exception {
        String s1 = "abc";
        String s2 = "ab" + "c";
        assertTrue(s1 == s2);
    }

    @Test
    public void variableAppend() throws Exception {
        String abc = "abc";
        String ab = "ab";
        String a = "a";
        String s1 = a + "b";
        String s2 = s1 + "c";
        assertTrue(s1.equals(ab));
        assertTrue(s1 != ab);
        assertTrue(s2.equals(abc));
        assertTrue(s2 != abc);
    }

    @Test
    public void variableAppendFinal() throws Exception {
        String ab = "ab";
        String a = "a";
        String b = "b";
        final String fa = "a";
        final String fb = "b";
        assertTrue(a + b != ab);
        assertTrue(a + fb != ab);
        assertTrue("a" + fb == ab);
        assertTrue(fa + b != ab);
        assertTrue(fa + "b" == ab);
        assertTrue(fa + fb == ab);
    }

    @SuppressWarnings("UnnecessaryLocalVariable")
    @Test
    public void valueOfConfusion() throws Exception {
        char[] arr = new char[]{'a', 'b', 'c'};
        String s1 = String.valueOf(arr);
        Object obj = arr;
        String s2 = String.valueOf(obj);
        assertFalse(s1.equals(s2));
    }
}
