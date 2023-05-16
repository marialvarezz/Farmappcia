package farmappceuticos.farmappcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class Questions {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="pregunta")
    private String pregunta;
    @Column(name="option1")
    private String option1;
    @Column(name="option2")
    private String option2;
    @Column(name="option3")
    private String option3;
    @Column(name="option4")
    private String option4;
    @Column(name="option5")
    private String option5;
    @Column(name="fecha_insert")
    private LocalDateTime fechaInsert;
    @Column(name="fecha_update")
    private LocalDateTime fechaUpdate;




    //Relaciones

    @ManyToMany
    @JoinTable(
            name = "answers_questionnaire",
            joinColumns = @JoinColumn(name = "questionsId"),
            inverseJoinColumns = @JoinColumn(name = "questionnaireId")
    )
    private List<Questionnaire> questionnaires;






}
