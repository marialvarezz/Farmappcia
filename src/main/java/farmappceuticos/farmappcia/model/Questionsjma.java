package farmappceuticos.farmappcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class Questionsjma {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="pregunta")
    private String pregunta;
    @Column(name="tipo",length = 1)
    private String tipo;
    @Column(name="fecha_insert")
    private LocalDateTime fechaInsert;
    @Column(name="fecha_update")
    private LocalDateTime fechaUpdate;

    //Listado de posibles respuestas
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "question_posiblerespuesta",
            joinColumns = {@JoinColumn(name = "questio_id") },
            inverseJoinColumns = {@JoinColumn(name = "posiblerespuesta_id")}
    )
    private Set<PosiblesRespuestas> posiblesRespuestas = new HashSet<>();

    //Relaciones

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL , mappedBy = "questionsjmas")
    private Set<Questionnairejma>  questionnairejmas = new HashSet<>();

}
