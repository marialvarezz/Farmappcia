package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.Illness;
import farmappceuticos.farmappcia.model.Questions;
import farmappceuticos.farmappcia.repositories.IllnessRepository;
import farmappceuticos.farmappcia.repositories.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IllnessService extends AbstractBusinessServiceSoloEnt <Illness,Integer, IllnessRepository> {
    @Autowired
    private IllnessRepository questionsRepository;

    protected IllnessService(IllnessRepository illnessRepository) {
        super(illnessRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD
}
