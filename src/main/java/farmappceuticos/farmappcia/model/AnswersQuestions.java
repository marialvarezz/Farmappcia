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

    //Cruce con etiqueta
    @ManyToOne
    @MapsId("answers")
    @JoinColumn(name = "answer_id")
    Answers answers;

    //Cruce con Galeria
    @ManyToOne
    @MapsId("questions")
    @JoinColumn(name = "id_questions")
    Questions questions ;






}
