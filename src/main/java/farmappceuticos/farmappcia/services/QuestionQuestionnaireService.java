package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.QuestionQuestionnaire;
import farmappceuticos.farmappcia.model.Questionnaire;
import farmappceuticos.farmappcia.model.User;
import farmappceuticos.farmappcia.repositories.QuestionQuestionnaireRepository;
import farmappceuticos.farmappcia.repositories.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionQuestionnaireService extends AbstractBusinessServiceSoloEnt <QuestionQuestionnaire,Integer, QuestionQuestionnaireRepository> {
    @Autowired
    private QuestionQuestionnaireRepository questionQuestionnaireRepository;
    public List<QuestionQuestionnaire> findByQuestionnaireToAnswers(Questionnaire questionnaire){
        return questionQuestionnaireRepository.findByQuestionnaireToAnswers(questionnaire);}

    protected QuestionQuestionnaireService(QuestionQuestionnaireRepository questionQuestionnaireRepository) {
        super(questionQuestionnaireRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD


}
