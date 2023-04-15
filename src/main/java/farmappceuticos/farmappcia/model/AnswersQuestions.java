package farmappceuticos.farmappcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "answers_questions")
public class AnswersQuestions {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    //Relaciones

    //Cruce con answers
    @ManyToOne
    @MapsId("answersId")
    @JoinColumn(name = "answer_id")
    Answers answersToQuestions;

    //Cruce con questions
    @ManyToOne
    @MapsId("questionsId")
    @JoinColumn(name = "id_questions")
    Questions questionsToAnswers ;

    //Cruce con questionary
    @ManyToOne
    @MapsId("questionaryId")
    @JoinColumn(name = "id_questionary")
    Questionary questionaryToAnswers ;







}
