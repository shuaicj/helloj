package shuaicj.hello.persist.cache;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * The implementation for CachedUserService.
 *
 * @author shuaicj 2017/02/13
 */
@Service
@CacheConfig(cacheNames = "userCache")
public class CachedUserServiceImpl implements CachedUserService {

    @Override
    @Cacheable
    public User find(String username) {
        return new User(username, "china");
    }

    @Override
    @CacheEvict
    public void clearCache(String username) {
    }

    @Override
    @CachePut(key = "#username")
    public User update(String username, String address) {
        return new User(username, address);
    }
}
