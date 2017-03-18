package shuaicj.hello.persist.jpa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test UserRepository.
 *
 * @author shuaicj 2017/01/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@IfProfileValue(name = "spring.profiles.active", values = {"h2", "mysql"})
public class UserRepositoryTest {

    private static final String NAME = "shuaicj";
    private static final String PASS = "pass123";
    private static final String NAME2 = "newuser";
    private static final String PASS2 = "newpass";

    @Autowired
    private UserRepository repo;

    @Before
    public void setUp() throws Exception {
        repo.deleteByUsername(NAME);
        repo.deleteByUsername(NAME2);
    }

    @After
    public void tearDown() throws Exception {
        repo.deleteByUsername(NAME);
        repo.deleteByUsername(NAME2);
    }

    @Test
    public void save() throws Exception {
        repo.save(new User(NAME, PASS));
        User u = repo.findByUsername(NAME);
        assertThat(u).isNotNull();
        assertThat(u.getUsername()).isEqualTo(NAME);
        assertThat(u.getPassword()).isEqualTo(PASS);
        assertThat(u.getCreatedTime()).isNotNull();
        assertThat(u.getCreatedTime()).isEqualTo(u.getUpdatedTime());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void saveDuplicate() throws Exception {
        repo.save(new User(NAME, PASS));
        repo.save(new User(NAME, PASS));
    }

    @Test
    public void saveReturnsId() throws Exception {
        User u1 = repo.save(new User(NAME, PASS));
        User u2 = repo.save(new User(NAME2, PASS2));
        assertThat(u2.getId()).isEqualTo(u1.getId() + 1);
    }

    @Test
    public void findByUsername() throws Exception {
        repo.save(new User(NAME, PASS));
        User user = repo.findByUsername(NAME);
        assertThat(user.getPassword()).isEqualTo(PASS);
    }

    @Test
    public void findByUsernameNotExists() throws Exception {
        assertThat(repo.findByUsername(NAME)).isNull();
    }

    @Test
    public void deleteByUsername() throws Exception {
        repo.save(new User(NAME, PASS));
        assertThat(repo.findByUsername(NAME)).isNotNull();
        repo.deleteByUsername(NAME);
        assertThat(repo.findByUsername(NAME)).isNull();
    }

    @Test
    public void deleteByUsernameNotExists() throws Exception {
        assertThat(repo.findByUsername(NAME)).isNull();
        repo.deleteByUsername(NAME);
        assertThat(repo.findByUsername(NAME)).isNull();
    }

    @Test
    public void time() throws Exception {
        repo.save(new User(NAME, PASS));
        User u = repo.findByUsername(NAME);
        Date createdTime = u.getCreatedTime();
        Date updatedTime = u.getUpdatedTime();
        assertThat(createdTime).isNotNull();
        assertThat(updatedTime).isEqualTo(createdTime);

        Thread.sleep(1000);

        u.setPassword(PASS2);
        u = repo.save(u);
        assertThat(u.getCreatedTime()).isEqualTo(createdTime);
        assertThat(u.getUpdatedTime()).isAfter(createdTime);
    }
}