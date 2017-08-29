package shuaicj.hello.constant.interf;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * Test Constant Interface Anti-Pattern and show that why it is evil.
 *
 * @author shuaicj 2017/08/29
 */
public class ConstantInterfaceTest {

    @Test
    public void baseConst() {
        assertThat(BaseConst.LOCATION).isEqualTo("This is in BaseConst.");
    }

    @Test
    public void subConst() {
        assertThat(SubConst.LOCATION).isEqualTo("This is in SubConst.");
    }

    @Test
    public void subConstImpl() {
        assertThat(SubConstImpl.LOCATION).isEqualTo("This is in SubConstImpl.");
    }

    @Test
    public void evilBaseConst() {
        BaseConst constant = new SubConstImpl();
        assertThat(constant.LOCATION).isEqualTo("This is in BaseConst.").isNotEqualTo("This is in SubConstImpl.");
    }

    @Test
    public void evilSubConst() {
        SubConst constant = new SubConstImpl();
        assertThat(constant.LOCATION).isEqualTo("This is in SubConst.").isNotEqualTo("This is in SubConstImpl.");
    }
}
