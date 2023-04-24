package farmappceuticos.farmappcia.repositories;

import farmappceuticos.farmappcia.model.Illness;
import farmappceuticos.farmappcia.model.IncMedicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncMedicineRepository extends JpaRepository<IncMedicine,Integer> {


}
