package shuaicj.hello.persist.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * JPA interface for user.
 *
 * @author shuaicj 2017/01/15
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Transactional
    int deleteByUsername(String username);

    // Use this form to get the detail users affected.
    // List<User> deleteByUsername(String username);

    Page<User> findAll(Pageable pageable);

    List<User> findByUsernameIgnoreCase(String username);

    List<User> findByPasswordOrderByUsernameDesc(String password);

    int countByPassword(String password);

    boolean existsByUsername(String username);
}
