package farmappceuticos.farmappcia.repositories;

import farmappceuticos.farmappcia.model.Illness;
import farmappceuticos.farmappcia.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IllnessRepository extends JpaRepository<Illness,Integer> {


}
