package farmappceuticos.farmappcia.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="respuesta")
    private String respuesta;

    @Column(name="fecha_hora")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss tt") // indica el formato en que se espera la fecha
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss tt") // indica el formato en que se debe serializar la fecha en JSON
    private LocalDateTime fechaHora;

    //Relaciones

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    User user;

    @OneToMany(mappedBy = "answersToResults" )
    private Set<Results> resultsToAnswers;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "questionnaireId")
    private QuestionQuestionnaire questionnaire;






}
