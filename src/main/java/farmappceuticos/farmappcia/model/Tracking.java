package farmappceuticos.farmappcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tracing")
public class Tracking {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="titular")
    private String titular;

    @Column(name="descripción")
    private String descripcion;

    @Column(name="fecha_hora_insert")
    private LocalDateTime fechaHora;

    @Column(name="fecha_hora_update")
    private LocalDateTime fechaHoraUpdate;

    //Relaciones

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id_results")
    Results resultsToTracking;






}
