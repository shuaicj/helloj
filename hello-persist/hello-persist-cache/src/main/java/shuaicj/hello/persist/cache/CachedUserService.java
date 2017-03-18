package shuaicj.hello.persist.cache;

import shuaicj.hello.persist.jpa.User;

/**
 * The interface for cached user.
 *
 * @author shuaicj 2017/02/13
 */
public interface CachedUserService {

    User find(String username);

    void clearCache(String username);

    User update(String username, String password);
}
