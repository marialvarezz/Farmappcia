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
    @OneToOne(mappedBy = "questionnaire",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Answers answers;

    //Cruce con questions
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "questionsId")
    Questions questionsToQuestionnaire;

    //Cruce con questionary
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "questionnaireId")
    Questionnaire questionnaireToAnswers ;







}
