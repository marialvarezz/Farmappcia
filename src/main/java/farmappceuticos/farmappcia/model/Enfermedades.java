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
public class Enfermedades {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToMany(mappedBy = "enfermedades" , fetch = FetchType.EAGER)
    private Set<HistorialMedico> historialMedico;


}
