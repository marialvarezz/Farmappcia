package farmappceuticos.farmappcia.repositories;

import farmappceuticos.farmappcia.model.Reminder;
import farmappceuticos.farmappcia.model.Results;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReminderRepository extends JpaRepository<Reminder, Integer> {


}
