package shuaicj.hello.persist.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Mongo interface for user.
 *
 * @author shuaicj 2017/03/04
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);

    void deleteByUsername(String username);
}
