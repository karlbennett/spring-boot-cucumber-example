package example.spring.boot.data;

import example.spring.boot.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Karl Bennett
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
