package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.Answers;
import farmappceuticos.farmappcia.repositories.AnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswersService {
    @Autowired
    private AnswersRepository answersRepository;

    //Implementación de los métodos principales que se usan al entrar en el CRUD
    public List<Answers> findAll() {
        return answersRepository.findAll();
    }
    public Optional<Answers> findById(Integer id) {
        return answersRepository.findById(id);
    }

    public Answers save(Answers answers) {
        return answersRepository.save(answers);
    }
    public void deleteById(Integer id) {
        answersRepository.deleteById(id);
    }
}
