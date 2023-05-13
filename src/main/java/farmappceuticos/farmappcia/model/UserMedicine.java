package farmappceuticos.farmappcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
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

    private Integer diames;
    private Boolean notificar;
    private Boolean notificarTutor;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fechainicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fechafinal;

    private int cadahoras;



    //Calendario
            private List<LocalDateTime>momentos;
            private LocalDateTime momento;

            //Para mostrar la hora en el calendario
            private String hora;




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
