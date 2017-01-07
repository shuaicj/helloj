package shuaicj.hello.cpu;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test CPUHelper.
 *
 * @author shuaicj 2017/01/07
 */
public class CPUHelperTest {

    private CPUHelper helper = new CPUHelper();

    @Test
    public void getCPUNumber() throws Exception {
        assertThat(helper.getCPUNumber()).isPositive();
    }

}