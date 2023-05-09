package farmappceuticos.farmappcia.repositories;

import farmappceuticos.farmappcia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);

    User findUserByUsernameAndActiveTrue(String username);
}
