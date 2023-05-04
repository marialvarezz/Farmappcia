package farmappceuticos.farmappcia.repositories;

import farmappceuticos.farmappcia.model.Questions;
import farmappceuticos.farmappcia.model.UserMedicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMedicineRepository extends JpaRepository<UserMedicine,Integer> {


}
