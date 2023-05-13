package farmappceuticos.farmappcia.repositories;

import farmappceuticos.farmappcia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String Email);

    User findByUsername(String username);

    List<User> findByTutorMail(String tutorMail);
}
