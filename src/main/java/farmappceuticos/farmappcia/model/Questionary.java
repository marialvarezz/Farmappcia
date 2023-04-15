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
@Table(name = "questionary")
public class Questionary {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="nombre")
    private String nombre;

    @Column(name="descripción")
    private String descripcion;

    @Column(name="fecha_hora")
    private LocalDateTime fechaHora;

    //Relaciones

    @OneToMany(mappedBy = "questionaryToAnswers" , fetch = FetchType.EAGER)
    private Set<AnswersQuestions> answersToQuestions;






}
