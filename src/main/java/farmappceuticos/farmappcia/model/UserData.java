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
@Table(name = "userData")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="direccion")
    private String direccion;

    @Column(name="ciudad")
    private String ciudad;

    @Column(name="telefono")
    private String telefono;

    @Column(name="grupoSangre")
    private String grupoSangre;

    @Column(name="alergias")
    private String alergias;



    @Column(name="altura")
    private String altura;

    private String peso;

    @Column(name="fechaInsert")
    private LocalDateTime fechaInsert;


    //Relaciones

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userToUserData;

}
