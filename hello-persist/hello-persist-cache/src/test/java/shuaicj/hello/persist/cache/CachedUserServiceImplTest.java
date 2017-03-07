package shuaicj.hello.persist.cache;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.junit4.SpringRunner;
import shuaicj.hello.persist.jdbc.template.User;

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

    @Autowired
    private CachedUserService userService;

    @Autowired
    private JdbcTemplate jdbc;

    @Before
    public void setUp() throws Exception {
        jdbcDelete(NAME);
        jdbcInsert(NAME, PASS);
        userService.clearCache(NAME);
    }

    @Test
    public void find() throws Exception {
        User user1 = userService.find(NAME);
        User user2 = userService.find(NAME);
        assertTrue(user1 == user2);
    }

    @Test
    public void delete() throws Exception {
        User user1 = userService.find(NAME);
        userService.clearCache(NAME);
        User user2 = userService.find(NAME);
        assertTrue(user1 != user2);
    }

    @Test
    public void update() throws Exception {
        User user1 = userService.find(NAME);
        User user2 = userService.update(NAME, "new pass");
        User user3 = userService.find(NAME);
        User user4 = userService.find(NAME);
        assertTrue(user1 != user2);
        assertTrue(user2 == user3);
        assertTrue(user3 == user4);
    }

    private void jdbcDelete(String username) throws Exception {
        jdbc.update("delete from user where username = ?", username);
    }

    private void jdbcInsert(String username, String password) throws Exception {
        jdbc.update("insert into user(username, password) values(?, ?)", username, password);
    }

    private int jdbcCount(String username, String password) throws Exception {
        String sql = "select count(*) from user where username = ? and password = ?";
        return jdbc.queryForObject(sql, Integer.class, username, password);
    }
}