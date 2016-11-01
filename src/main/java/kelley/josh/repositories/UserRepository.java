package kelley.josh.repositories;

import kelley.josh.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by joshuakelley on 11/1/16.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByAccountNumber(Long accountNumber);

}
