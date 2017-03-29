package shuaicj.hello.lombok;

import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test LombokPerson.
 *
 * @author shuaicj 2017/03/29
 */
public class LombokPersonTest {

    private static final String NAME = "shuaicj";
    private static final Date BIRTH = new Date();
    private static final String ADDRESS = "china";

    @Test
    public void testGetterAndSetter() throws Exception {
        LombokPerson person = new LombokPerson(NAME, BIRTH);
        assertThat(person.getName()).isEqualTo(NAME);
        person.setName(NAME + "abcd");
        assertThat(person.getName()).isEqualTo(NAME + "abcd");
        assertThat(person.getBirth()).isEqualTo(BIRTH);
        assertThat(person.getAddress()).isNull();
        person.setAddress(ADDRESS);
        assertThat(person.getAddress()).isEqualTo(ADDRESS);
    }

    @Test
    public void testAllArgsCtor() throws Exception {
        LombokPerson person = new LombokPerson(NAME, BIRTH, ADDRESS);
        assertThat(person.getName()).isEqualTo(NAME);
        assertThat(person.getBirth()).isEqualTo(BIRTH);
        assertThat(person.getAddress()).isEqualTo(ADDRESS);
    }

    @Test
    public void testRequiredArgsCtor() throws Exception {
        LombokPerson person = new LombokPerson(NAME, BIRTH);
        assertThat(person.getName()).isEqualTo(NAME);
        assertThat(person.getBirth()).isEqualTo(BIRTH);
        assertThat(person.getAddress()).isNull();
    }

    @Test(expected = NullPointerException.class)
    public void testCtorNonNull() throws Exception {
        new LombokPerson(null, BIRTH);
    }

    @Test(expected = NullPointerException.class)
    public void testSetterNonNull() throws Exception {
        LombokPerson person = new LombokPerson(NAME, BIRTH);
        person.setName(null);
    }
}