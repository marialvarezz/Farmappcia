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
@Table(name = "userData")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido1")
    private String apellido1;

    @Column(name="apellido2")
    private String apellido2;

    @Column(name="direccion")
    private String direccion;

    @Column(name="ciudad")
    private String ciudad;

    @Column(name="telefono")
    private String telefono;

    @Column(name="email")
    private String email;

    @Column(name="grupoSangre")
    private String grupoSangre;

    @Column(name="alergias")
    private String alergias;

    @Column(name="altura")
    private String altura;

    @Column(name="fechaInsert")
    private String fechaInsert;

    @Column(name="fechaUpdate")
    private String fechaUpdate;

    //Relaciones

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userToUserData;

}
