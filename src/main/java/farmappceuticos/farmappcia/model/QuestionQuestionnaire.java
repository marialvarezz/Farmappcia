package farmappceuticos.farmappcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "answers_questionnaire")
public class QuestionQuestionnaire {

    @EmbeddedId
    private QuestionQuestionnaireId id;

    //Relaciones

    //Cruce con answers
    @OneToOne
    @JoinColumn(name = "answerId")
    private Answers answer;

    //Cruce con questions

    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "questionsId")
    Questions question;

    //Cruce con questionary
    @ManyToOne
    @MapsId("questionnaireId")
    @JoinColumn(name = "questionnaireId")
    Questionnaire questionnaire;









}
