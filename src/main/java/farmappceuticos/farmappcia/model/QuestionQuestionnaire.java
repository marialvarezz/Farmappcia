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
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    //Relaciones

    //Cruce con answers
    @OneToOne(mappedBy = "questionnaire",cascade = CascadeType.ALL)
    private Answers answers;

    //Cruce con questions
    @ManyToOne
    @JoinColumn(name = "questionsId")
    Questions questionsToQuestionnaire;

    //Cruce con questionary
    @ManyToOne
    @JoinColumn(name = "questionnaireId")
    Questionnaire questionnaireToAnswers ;







}
