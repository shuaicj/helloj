package shuaicj.hello.persist.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import shuaicj.hello.persist.jpa.User;
import shuaicj.hello.persist.jpa.UserRepository;

import javax.transaction.Transactional;

/**
 * The implementation for CachedUserService.
 *
 * @author shuaicj 2017/02/13
 */
@Service
@CacheConfig(cacheNames = "userCache")
public class CachedUserServiceImpl implements CachedUserService {

    @Autowired
    private UserRepository repo;

    @Override
    @Cacheable
    public User find(String username) {
        return repo.findByUsername(username);
    }

    @Override
    @CacheEvict
    public void clearCache(String username) {
    }

    @Override
    @Transactional
    @CachePut(key = "#username")
    public User update(String username, String password) {
        User u = repo.findByUsername(username);
        u.setPassword(password);
        return repo.save(u);
    }
}
