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
@Table(name = "questionnaire")
public class Questionnaire {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="fecha_hora")
    private LocalDateTime fechaHora;

    //Relaciones

    @ManyToMany
    @JoinTable(
            name = "answers_questionnaire",
            joinColumns = @JoinColumn(name = "questionnaireId"),
            inverseJoinColumns = @JoinColumn(name = "questionsId")
    )
    private List<Questions> questions;

}
