package farmappceuticos.farmappcia.repositories;

import farmappceuticos.farmappcia.model.Illness;
import farmappceuticos.farmappcia.model.MedicalHistory;
import farmappceuticos.farmappcia.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory,Integer> {

Page<MedicalHistory> findByUser(User user, Pageable pageable);
}
