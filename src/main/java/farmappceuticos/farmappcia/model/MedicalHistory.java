package farmappceuticos.farmappcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medicalHistory")
public class MedicalHistory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne(cascade = CascadeType.ALL) //Revisar el fetch type
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userToHistorialMedico;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "illness_id")
    Illness illnessToMedicalHistory;

}
