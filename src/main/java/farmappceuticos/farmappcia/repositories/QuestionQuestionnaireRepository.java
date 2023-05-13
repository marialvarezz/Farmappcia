package farmappceuticos.farmappcia.repositories;

import farmappceuticos.farmappcia.model.QuestionQuestionnaire;
import farmappceuticos.farmappcia.model.Questionnaire;
import farmappceuticos.farmappcia.model.Questions;
import farmappceuticos.farmappcia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionQuestionnaireRepository extends JpaRepository<QuestionQuestionnaire, Integer> {

    List<QuestionQuestionnaire> findByQuestionnaireToAnswers(Questionnaire questionnaire);


}
