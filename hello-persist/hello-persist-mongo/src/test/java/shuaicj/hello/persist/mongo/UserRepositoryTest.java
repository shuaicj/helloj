package shuaicj.hello.persist.mongo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test UserRepository.
 *
 * @author shuaicj 2017/03/04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@IfProfileValue(name = "spring.profiles.active", values = {"mongodb", "mongoembed"})
public class UserRepositoryTest {

    private static final String NAME = "shuaicj";
    private static final String PASS = "pass123";
    private static final String PHONE1 = "phone1";
    private static final String PHONE2 = "phone2";

    @Autowired
    private UserRepository repo;

    @Before
    public void setUp() throws Exception {
        repo.deleteAll();
    }

    @After
    public void tearDown() throws Exception {
        setUp();
    }

    @Test
    public void delete() throws Exception {
        repo.save(new User(NAME, PASS));
        assertThat(repo.findByUsername(NAME)).isNotNull();
        repo.deleteByUsername(NAME);
        assertThat(repo.findByUsername(NAME)).isNull();
    }

    @Test
    public void save() throws Exception {
        User u = new User(NAME, PASS);
        u.setPhones(Arrays.asList(PHONE1, PHONE2));
        repo.save(u);
        u = repo.findByUsername(NAME);
        assertThat(u).isNotNull();
        assertThat(u.getUsername()).isEqualTo(NAME);
        assertThat(u.getPassword()).isEqualTo(PASS);
        assertThat(u.getPhones()).containsExactly(PHONE1, PHONE2);
        assertThat(u.getCreatedTime()).isNotNull();
        assertThat(u.getUpdatedTime()).isEqualTo(u.getCreatedTime());
    }

    @Test(expected = DuplicateKeyException.class)
    public void duplicate() throws Exception {
        repo.save(new User(NAME, PASS));
        repo.save(new User(NAME, PASS));
    }

    @Test
    public void updateTime() throws Exception {
        repo.save(new User(NAME, PASS));
        User u = repo.findByUsername(NAME);
        assertThat(u.getCreatedTime()).isEqualTo(u.getUpdatedTime());

        Thread.sleep(2000);

        u.setPassword("newpass");
        User u2 = repo.save(u);
        assertThat(u2.getId()).isEqualTo(u.getId());
        assertThat(u2.getUsername()).isEqualTo(u.getUsername());
        assertThat(u2.getPassword()).isEqualTo("newpass");
        assertThat(u2.getCreatedTime()).isEqualTo(u.getCreatedTime());
        assertThat(u2.getUpdatedTime()).isAfter(u.getCreatedTime());
    }

    @Test
    public void arrayOps() throws Exception {
        User u = new User(NAME, PASS);
        u.setPhones(new ArrayList<>(Arrays.asList(PHONE1, PHONE2)));
        u = repo.save(u);
        assertThat(u.getPhones()).containsExactly(PHONE1, PHONE2);
        u.getPhones().add(PHONE1);
        u = repo.save(u);
        assertThat(u.getPhones()).containsExactly(PHONE1, PHONE2, PHONE1);
        u.getPhones().remove(0);
        u = repo.save(u);
        assertThat(u.getPhones()).containsExactly(PHONE2, PHONE1);
        u.getPhones().set(1, PHONE2);
        u = repo.save(u);
        assertThat(u.getPhones()).containsExactly(PHONE2, PHONE2);
    }
}