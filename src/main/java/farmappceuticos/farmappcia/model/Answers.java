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
@Table(name = "answers")
public class Answers {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="respuesta")
    private String respuesta;

    @Column(name="fecha_hora")
    private LocalDateTime fechaHora;

    //Relaciones

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    User userToAnswers;

    @OneToMany(mappedBy = "answersToResults" , fetch = FetchType.EAGER)
    private Set<Results> resultsToAnswers;

    @OneToMany(mappedBy = "answersToQuestions", cascade = CascadeType.PERSIST )
    private Set<AnswersQuestions> answersQuestions;






}
