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
    private LocalDateTime fechaHora;
    @Column(name="especializacion")
    private String especializacion;
    @Column(name="ubicacion")
    private String ubicacion;
    @Column(name="notificar")
    private Boolean notificar;
    @Column(name="notificar_tutor")
    private Boolean notificarTutor;

    //Relaciones

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id_agenda")
    Agenda agendaToEvents;

public Event(String nombre, String descripcion, LocalDateTime fechaHora, String especializacion, String ubicacion, Boolean notificar, Boolean notificarTutor){
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.fechaHora = fechaHora;
    this.especializacion = especializacion;
    this.ubicacion = ubicacion;
    this.notificar = notificar;
    this.notificarTutor = notificarTutor;
}




}
