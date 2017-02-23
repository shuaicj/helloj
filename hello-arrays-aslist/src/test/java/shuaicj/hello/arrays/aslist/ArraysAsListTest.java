package shuaicj.hello.arrays.aslist;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test Arrays.asList().
 *
 * @author shuaicj 2017/02/23
 */
public class ArraysAsListTest {

    @Test
    public void sequence() throws Exception {
        assertThat(Arrays.asList("abc", "def")).containsExactly("abc", "def");
    }

    @Test
    public void array() throws Exception {
        assertThat(Arrays.asList(new String[]{"abc", "def"})).containsExactly("abc", "def");
    }

    // compile error
    @Test
    public void arraySequence() throws Exception {
        // assertThat(Arrays.asList(new String[]{"ab", "cd"}, new String[]{"ef", "gh"}))
        //         .containsExactly("ab", "cd", "ef", "gh");
    }
}
