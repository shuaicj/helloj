package shuaicj.hello.persist.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import shuaicj.hello.persist.jdbc.template.User;
import shuaicj.hello.persist.jdbc.template.UserDao;

/**
 * The implementation for CachedUserService.
 *
 * @author shuaicj 2017/02/13
 */
@Service
@CacheConfig(cacheNames = "userCache")
public class CachedUserServiceImpl implements CachedUserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Cacheable
    public User find(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    @CacheEvict
    public void clearCache(String username) {
    }

    @Override
    @CachePut(key = "#username")
    public User update(String username, String password) {
        userDao.updatePasswordByUsername(username, password);
        return new User(username, password);
    }
}
