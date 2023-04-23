package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.QuestionQuestionnaire;
import farmappceuticos.farmappcia.model.Questionnaire;
import farmappceuticos.farmappcia.repositories.QuestionQuestionnaireRepository;
import farmappceuticos.farmappcia.repositories.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionQuestionnaireService extends AbstractBusinessServiceSoloEnt <QuestionQuestionnaire,Integer, QuestionQuestionnaireRepository> {
    @Autowired
    private QuestionQuestionnaireRepository questionQuestionnaireRepository;

    protected QuestionQuestionnaireService(QuestionQuestionnaireRepository questionQuestionnaireRepository) {
        super(questionQuestionnaireRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD


}
