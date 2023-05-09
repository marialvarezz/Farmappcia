package farmappceuticos.farmappcia.repositories;

import farmappceuticos.farmappcia.model.Agenda;

import farmappceuticos.farmappcia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgendaRepository extends JpaRepository<Agenda, Integer> {

    public Optional<Agenda> findByUserToAgenda(User user);

}
