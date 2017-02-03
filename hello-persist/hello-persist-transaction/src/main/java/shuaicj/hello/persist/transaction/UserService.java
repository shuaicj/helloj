package shuaicj.hello.persist.transaction;

import org.springframework.transaction.annotation.Transactional;
import shuaicj.hello.persist.jdbc.template.User;

import java.util.List;

/**
 * The interface for user service.
 *
 * @author shuaicj 2017/02/03
 */
public interface UserService {

    @Transactional
    void register(List<User> users);
}
