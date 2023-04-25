package farmappceuticos.farmappcia.repositories;

import farmappceuticos.farmappcia.model.QuestionQuestionnaire;
import farmappceuticos.farmappcia.model.QuestionQuestionnaireId;
import farmappceuticos.farmappcia.model.Questionnaire;
import farmappceuticos.farmappcia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionQuestionnaireRepository extends JpaRepository<QuestionQuestionnaire, Integer> {

    Optional<QuestionQuestionnaire> findById(QuestionQuestionnaireId id);
    Optional<Questionnaire>findByQuestionnaire(Questionnaire questionnaire);

}
