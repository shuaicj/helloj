package shuaicj.hello.persist.db.init;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test UserRepository.
 *
 * @author shuaicj 2017/01/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DbInitTest {

    private static final String NAME = "shuaicj";
    private static final String PASS = "pass123";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void exists() throws Exception {
        int count = jdbcTemplate.queryForObject("select count(*) from user where username = ? and password = ?",
                Integer.class, NAME, PASS);
        assertThat(count).isEqualTo(1);
    }
}