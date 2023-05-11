package farmappceuticos.farmappcia.repositories;

import farmappceuticos.farmappcia.model.Answers;
import farmappceuticos.farmappcia.model.QuestionQuestionnaire;
import farmappceuticos.farmappcia.model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswersRepository extends JpaRepository<Answers,Integer> {

    Answers findByQuestionnaire(QuestionQuestionnaire questionnaire);

}
