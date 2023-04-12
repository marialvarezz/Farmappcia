package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.Questions;
import farmappceuticos.farmappcia.model.User;
import farmappceuticos.farmappcia.repositories.QuestionsRepository;
import farmappceuticos.farmappcia.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionsService {
    @Autowired
    private QuestionsRepository questionsRepository;

    //Implementación de los métodos principales que se usan al entrar en el CRUD
    public List<Questions> findAll() {
        return questionsRepository.findAll();
    }
    public Optional<Questions> findById(Integer id) {
        return questionsRepository.findById(id);
    }

    public Questions save(Questions questions) {
        return questionsRepository.save(questions);
    }
    public void deleteById(Integer id) {
        questionsRepository.deleteById(id);
    }
}
