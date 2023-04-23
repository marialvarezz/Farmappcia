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
@Table(name = "enfermedades")
public class Illness {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="tipo")
    private String tipo;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="sintomas")
    private String sintomas;

  //Relaciones

    @OneToMany(mappedBy = "illnessToMedicalHistory" , fetch = FetchType.EAGER)
    private Set<MedicalHistory> medicalHistoryToIllness;


}
