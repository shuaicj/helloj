package shuaicj.hello.persist.cache;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.junit4.SpringRunner;
import shuaicj.hello.persist.jpa.User;
import shuaicj.hello.persist.jpa.UserRepository;

import static org.junit.Assert.assertTrue;

/**
 * Test CachedUserServiceImpl.
 *
 * @author shuaicj 2017/02/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@IfProfileValue(name = "spring.profiles.active", values = {"h2", "mysql"})
public class CachedUserServiceImplTest {

    private static final String NAME = "shuaicj";
    private static final String PASS = "pass123";
    private static final String NAME2 = "newuser";
    private static final String PASS2 = "newpass";

    @Autowired
    private CachedUserService userService;

    @Autowired
    private UserRepository repo;

    @Before
    public void setUp() throws Exception {
        repo.deleteByUsername(NAME);
        repo.deleteByUsername(NAME2);
        userService.clearCache(NAME);
        userService.clearCache(NAME2);
    }

    @After
    public void tearDown() throws Exception {
        repo.deleteByUsername(NAME);
        repo.deleteByUsername(NAME2);
    }

    @Test
    public void find() throws Exception {
        repo.save(new User(NAME, PASS));
        User user1 = userService.find(NAME);
        User user2 = userService.find(NAME);
        assertTrue(user1 == user2);
    }

    @Test
    public void delete() throws Exception {
        repo.save(new User(NAME, PASS));
        User user1 = userService.find(NAME);
        userService.clearCache(NAME);
        User user2 = userService.find(NAME);
        assertTrue(user1 != user2);
    }

    @Test
    public void update() throws Exception {
        repo.save(new User(NAME, PASS));
        User user1 = userService.find(NAME);
        User user2 = userService.update(NAME, PASS2);
        User user3 = userService.find(NAME);
        User user4 = userService.find(NAME);
        assertTrue(user1 != user2);
        assertTrue(user2 == user3);
        assertTrue(user3 == user4);
    }
}