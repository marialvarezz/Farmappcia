package farmappceuticos.farmappcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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

    @Column(name="diagnostico")
    private String diagnostico;


    @Column(name="fechaIncidencia")
    private LocalDate fechaIncidencia;

    @Column(name="ingreso")
    private String ingreso;

    @Column(name="ubiHospital")
    private String ubiHospital;

    //Relaciones

    @ManyToOne(cascade = CascadeType.ALL) //Revisar el fetch type
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userToHistorialMedico;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "illness_id")
    Illness illnessToMedicalHistory;

}
