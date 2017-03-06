package shuaicj.hello.persist.mongo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test UserRepository.
 *
 * @author shuaicj 2017/03/04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    private static final String NAME = "shuaicj";
    private static final String PASS = "pass123";

    @Autowired
    private UserRepository repo;

    @Before
    public void setUp() throws Exception {
        repo.deleteByUsername(NAME);
        repo.save(new User(NAME, PASS));
    }

    @Test
    public void delete() throws Exception {
        repo.deleteByUsername(NAME);
        assertThat(repo.findByUsername(NAME)).isNull();
    }

    @Test
    public void save() throws Exception {
        repo.deleteByUsername(NAME);
        repo.save(new User(NAME, PASS));
        User u = repo.findByUsername(NAME);
        assertThat(u).isNotNull();
        assertThat(u.getUsername()).isEqualTo(NAME);
        assertThat(u.getPassword()).isEqualTo(PASS);
        assertThat(u.getCreatedTime()).isNotNull();
        assertThat(u.getUpdatedTime()).isEqualTo(u.getCreatedTime());
    }

    @Test(expected = DuplicateKeyException.class)
    public void duplicate() throws Exception {
        repo.save(new User(NAME, PASS));
    }

    @Test
    public void update() throws Exception {
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
}