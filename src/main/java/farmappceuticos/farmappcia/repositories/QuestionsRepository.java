package farmappceuticos.farmappcia.repositories;

import farmappceuticos.farmappcia.model.Questions;
import farmappceuticos.farmappcia.model.User;
import org.hibernate.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionsRepository extends JpaRepository<Questions,Integer> {


}
