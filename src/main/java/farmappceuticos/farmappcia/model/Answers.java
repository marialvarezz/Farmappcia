package farmappceuticos.farmappcia.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss tt") // indica el formato en que se espera la fecha
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss tt") // indica el formato en que se debe serializar la fecha en JSON
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
