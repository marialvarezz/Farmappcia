package farmappceuticos.farmappcia.repositories;

import farmappceuticos.farmappcia.model.Role;
import farmappceuticos.farmappcia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findByName(String name);
}
