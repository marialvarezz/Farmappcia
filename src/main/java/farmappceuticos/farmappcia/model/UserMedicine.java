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
@Table(name = "user_medicine")
public class UserMedicine {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(name="active")
    private String active;

    @Column(name="descripción")
    private String descripcion;



    //Relaciones

    @ManyToOne
    @MapsId("user")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId("medicine")
    @JoinColumn(name = "id_medicine")
    Medicine medicine;







}
