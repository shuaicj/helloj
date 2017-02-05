package shuaicj.hello.enumtest;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test enum ABCDE.
 *
 * @author shuaicj 2017/02/05
 */
public class ABCDETest {

    @Test
    public void name() throws Exception {
        assertThat(ABCDE.A.name()).isEqualTo("A");
        assertThat(ABCDE.B.name()).isEqualTo("B");
        assertThat(ABCDE.C.name()).isEqualTo("C");
        assertThat(ABCDE.D.name()).isEqualTo("D");
        assertThat(ABCDE.E.name()).isEqualTo("E");
    }

    @Test
    public void lowerCase() throws Exception {
        assertThat(ABCDE.A.getLowerCase()).isEqualTo("a");
        assertThat(ABCDE.B.getLowerCase()).isEqualTo("b");
        assertThat(ABCDE.C.getLowerCase()).isEqualTo("c");
        assertThat(ABCDE.D.getLowerCase()).isEqualTo("d");
        assertThat(ABCDE.E.getLowerCase()).isEqualTo("e");
    }

    @Test
    public void ordinal() throws Exception {
        assertThat(ABCDE.A.ordinal()).isEqualTo(0);
        assertThat(ABCDE.B.ordinal()).isEqualTo(1);
        assertThat(ABCDE.C.ordinal()).isEqualTo(2);
        assertThat(ABCDE.D.ordinal()).isEqualTo(3);
        assertThat(ABCDE.E.ordinal()).isEqualTo(4);
    }

    @Test
    public void valueOf() throws Exception {
        assertThat(ABCDE.valueOf("A")).isEqualTo(ABCDE.A);
        assertThat(ABCDE.valueOf("B")).isEqualTo(ABCDE.B);
        assertThat(ABCDE.valueOf("C")).isEqualTo(ABCDE.C);
        assertThat(ABCDE.valueOf("D")).isEqualTo(ABCDE.D);
        assertThat(ABCDE.valueOf("E")).isEqualTo(ABCDE.E);
    }

    @Test
    public void values() throws Exception {
        assertThat(ABCDE.values()).containsExactly(ABCDE.A, ABCDE.B, ABCDE.C, ABCDE.D, ABCDE.E);
        for (ABCDE abcde : ABCDE.values()) {
            assertThat(abcde).isIn(ABCDE.A, ABCDE.B, ABCDE.C, ABCDE.D, ABCDE.E);
        }
    }
}