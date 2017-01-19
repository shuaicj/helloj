package shuaicj.hello.persist.jpa;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test UserRepository.
 *
 * @author shuaicj 2017/01/15
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
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void duplicate() throws Exception {
        repo.save(new User(NAME, PASS));
    }
}