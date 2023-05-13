package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.Answers;
import farmappceuticos.farmappcia.model.QuestionQuestionnaire;
import farmappceuticos.farmappcia.repositories.AnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswersService extends AbstractBusinessServiceSoloEnt <Answers,Integer, AnswersRepository> {
    @Autowired
    private AnswersRepository answersRepository;

    public Answers findByQuestionnaireToAnswers(QuestionQuestionnaire questionnaire){
        return answersRepository.findByQuestionnaire(questionnaire);}

    protected AnswersService(AnswersRepository answersRepository) {
        super(answersRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD
}
