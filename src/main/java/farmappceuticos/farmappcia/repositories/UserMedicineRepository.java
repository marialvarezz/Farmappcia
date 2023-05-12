package farmappceuticos.farmappcia.repositories;


import farmappceuticos.farmappcia.model.Event;
import farmappceuticos.farmappcia.model.Questions;
import farmappceuticos.farmappcia.model.UserMedicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface UserMedicineRepository extends JpaRepository<UserMedicine,Integer> {

    List<UserMedicine> findUserMedicineByFechainicioBetween(LocalDateTime from, LocalDateTime to);

}
