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
@Table(name = "results")
public class Results {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="titular")
    private String titular;

    @Column(name="descripción")
    private String descripcion;

    @Column(name="fecha_hora")
    private LocalDateTime fechaHora;

    //Relaciones

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id_answers")
    Answers answersToResults;

    @OneToMany(mappedBy = "resultsToTracking" , fetch = FetchType.EAGER)
    private Set<Tracking> trackingToResults;

}
