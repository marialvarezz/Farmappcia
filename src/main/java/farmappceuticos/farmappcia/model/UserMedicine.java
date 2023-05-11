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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name="active")
    private String active;

    @Column(name="descripción")
    private String descripcion;

    private Boolean notificar;
    private Boolean notificarTutor;
    private LocalDateTime fechainicio;
    private LocalDateTime fechafinal;
    private int cadahoras;



    //Relaciones

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    User userToMedicine;

    @ManyToOne
    @JoinColumn(name = "id_medicine",referencedColumnName = "id")
    Medicine medicineToMedicine;

    @OneToMany(mappedBy = "userMedicineToReminder")
    private Set<Reminder> remindersToUserMedicine;







}
