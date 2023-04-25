package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.QuestionQuestionnaire;
import farmappceuticos.farmappcia.model.QuestionQuestionnaireId;
import farmappceuticos.farmappcia.model.Questionnaire;
import farmappceuticos.farmappcia.model.User;
import farmappceuticos.farmappcia.repositories.QuestionQuestionnaireRepository;
import farmappceuticos.farmappcia.repositories.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionQuestionnaireService extends AbstractBusinessServiceSoloEnt <QuestionQuestionnaire,Integer, QuestionQuestionnaireRepository> {
    @Autowired
    private QuestionQuestionnaireRepository questionQuestionnaireRepository;

    public Optional<QuestionQuestionnaire> findById(QuestionQuestionnaireId id) {
        return questionQuestionnaireRepository.findById(id);
    }
    public Optional<Questionnaire>findByQuestionnaire(Questionnaire questionnaire){
        return questionQuestionnaireRepository.findByQuestionnaire(questionnaire);
    }

    protected QuestionQuestionnaireService(QuestionQuestionnaireRepository questionQuestionnaireRepository) {
        super(questionQuestionnaireRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD


}
