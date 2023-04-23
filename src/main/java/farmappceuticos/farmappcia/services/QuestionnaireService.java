package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.Questionnaire;
import farmappceuticos.farmappcia.repositories.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireService extends AbstractBusinessServiceSoloEnt <Questionnaire,Integer, QuestionnaireRepository> {
    @Autowired
    private QuestionnaireRepository questionaryRepository;

    protected QuestionnaireService(QuestionnaireRepository questionaryRepository) {
        super(questionaryRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD


}
