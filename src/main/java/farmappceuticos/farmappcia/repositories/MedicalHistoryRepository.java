package farmappceuticos.farmappcia.repositories;

import farmappceuticos.farmappcia.model.Illness;
import farmappceuticos.farmappcia.model.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory,Integer> {


}
