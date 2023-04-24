package farmappceuticos.farmappcia.repositories;


import farmappceuticos.farmappcia.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Integer> {



}
