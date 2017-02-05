package shuaicj.hello.enumtest.op.extend;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test BasicOperation and ExtendedOperation.
 *
 * @author shuaicj 2017/02/05
 */
public class OperationExtendTest {

    @Test
    public void iterateByClass() throws Exception {
        for (Operation op : BasicOperation.class.getEnumConstants()) {
            assertThat(op).isIn(
                    BasicOperation.PLUS, BasicOperation.MINUS,
                    BasicOperation.TIMES, BasicOperation.DIVIDE);
        }
        for (Operation op : ExtendedOperation.class.getEnumConstants()) {
            assertThat(op).isIn(ExtendedOperation.EXP, ExtendedOperation.REMAINDER);
        }
    }

    @Test
    public void iterateByValues() throws Exception {
        for (Operation op : BasicOperation.values()) {
            assertThat(op).isIn(
                    BasicOperation.PLUS, BasicOperation.MINUS,
                    BasicOperation.TIMES, BasicOperation.DIVIDE);
        }
        for (Operation op : ExtendedOperation.values()) {
            assertThat(op).isIn(ExtendedOperation.EXP, ExtendedOperation.REMAINDER);
        }
    }
}