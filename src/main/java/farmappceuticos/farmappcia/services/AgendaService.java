package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.Agenda;
import farmappceuticos.farmappcia.model.User;
import farmappceuticos.farmappcia.repositories.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {
    @Autowired
    private AgendaRepository agendaRepository;

    //Implementación de los métodos principales que se usan al entrar en el CRUD
    public List<Agenda> findAll() {
        return agendaRepository.findAll();
    }
    public Optional<Agenda> findById(Integer id) {
        return agendaRepository.findById(id);
    }


    public Optional<Agenda>findByUserToAgenda(User user){
        return agendaRepository.findByUserToAgenda(user);
    }

    public Agenda save(Agenda agenda) {
        return agendaRepository.save(agenda);
    }
    public void deleteById(Integer id) {
        agendaRepository.deleteById(id);
    }
}
