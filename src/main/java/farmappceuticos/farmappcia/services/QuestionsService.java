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
public class QuestionsService extends AbstractBusinessServiceSoloEnt <Questions,Integer,QuestionsRepository> {
    @Autowired
    private QuestionsRepository questionsRepository;

    protected QuestionsService(QuestionsRepository questionsRepository) {
        super(questionsRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD
}
