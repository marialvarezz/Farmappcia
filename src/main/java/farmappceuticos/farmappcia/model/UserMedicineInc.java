package farmappceuticos.farmappcia.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_medicine_inc")
public class UserMedicineInc {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="id_medicine")
    private boolean idMedicine;

    @Column(name="reason")
    private String reason;

    @Column(name="active")
    private Boolean active;
    //Relaciones

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User userToMedicineInc;

}
