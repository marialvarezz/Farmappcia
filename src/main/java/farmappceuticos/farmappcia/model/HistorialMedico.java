package farmappceuticos.farmappcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "historialMedico")
public class HistorialMedico {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="sintomas")
    private String sintomas;

    @Column(name="fechaIncidencia")
    private String fechaIncidencia;

    @Column(name="ingreso")
    private String ingreso;

    @Column(name="ubiHospital")
    private String ubiHospital;

    //Relaciones

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "enfermedades_id")
    Enfermedades enfermedades;

}
