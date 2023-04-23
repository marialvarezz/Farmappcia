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
@Table(name = "reminder")
public class Reminder {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="date_start")
    private LocalDateTime dateStart;

    @Column(name="time_start")
    private LocalDateTime timeStart;

    @Column(name="date_final")
    private LocalDateTime dateFinal;

    @Column(name="period")
    private LocalDateTime period;

    //Relaciones

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user_medicine")
    UserMedicine userMedicineToReminder;






}
