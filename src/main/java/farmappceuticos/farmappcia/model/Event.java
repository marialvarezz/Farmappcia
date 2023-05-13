package farmappceuticos.farmappcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "event")
public class Event {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="fecha_hora")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fechahora;



    @Column(name="especializacion")
    private String especializacion;

    @Column(name="ubicacion")
    private String ubicacion;

    private Integer diames;

    private String hora;
    private String fecha;
    //Configuración notificaciones
    @Column(name="notificar")
    private Boolean notificar;

    @Column(name="notificar_tutor")
    private Boolean notificarTutor=false;

    private Integer numeroDias=0;
    private Integer numeroMinutos=0;
    private Integer numeroHoras=0;




    //Relaciones

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id_agenda")
    Agenda agendaToEvents;

public Event(String nombre, String descripcion, LocalDateTime fechaHora, String especializacion, String ubicacion, Boolean notificar, Boolean notificarTutor){
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.fechahora = fechaHora;

    this.especializacion = especializacion;
    this.ubicacion = ubicacion;
    this.notificar = notificar;
    this.notificarTutor = notificarTutor;
}




}
