package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.Agenda;
import farmappceuticos.farmappcia.model.Event;
import farmappceuticos.farmappcia.model.NotificacionAsincrona;
import farmappceuticos.farmappcia.model.User;
import farmappceuticos.farmappcia.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Optional;



@Log4j2
@Service
public class EventService extends AbstractBusinessServiceSoloEnt <Event,Integer,EventRepository>{
    @Autowired
    private EventRepository eventRepository;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    UserService1 userService1;
   @Autowired
   ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Autowired
    AgendaService agendaService;

    public Event crearEvento(Event event, Agenda agenda) {

            event.setAgendaToEvents(agenda);
            Event eventSaved = eventRepository.save(event);

            if (Boolean.TRUE.equals(eventSaved.getNotificar())) {
                crearAviso(eventSaved);
            }

            if (Boolean.TRUE.equals(eventSaved.getNotificarTutor())) {
                crearAvisoTutor(eventSaved);
            }

            return eventSaved;

    }


    public void crearAviso(Event event) {
        String expresionCron = "";

        LocalDateTime fechaAviso =
                event.getFechahora()
                        .minusMinutes(event.getNumeroMinutos())
                        .minusHours(event.getNumeroHoras())
                        .minusDays(event.getNumeroDias());

        expresionCron =
                "0 "
                        + fechaAviso.getMinute() + " "
                        + fechaAviso.getHour() + " "
                        + fechaAviso.getDayOfMonth() + " "
                        + fechaAviso.getMonth() + " "
                        + "?"
        ;
        log.info(expresionCron);
        CronTrigger cronTrigger = new CronTrigger(expresionCron);
      threadPoolTaskScheduler.schedule(
                new NotificacionAsincrona(
                        "cita médica",
                        event.getAgendaToEvents().getUserToAgenda().getEmail(),
                        "feelingcareapp@gmail.com"),
                cronTrigger
        );


    }

    public void crearAvisoTutor(Event event) {
        String expresionCron = "";

        LocalDateTime fechaAviso =
                event.getFechahora()
                        .minusMinutes(event.getNumeroMinutos())
                        .minusHours(event.getNumeroHoras())
                        .minusDays(event.getNumeroDias());

        expresionCron =
                "0 "
                        + fechaAviso.getMinute() + " "
                        + fechaAviso.getHour() + " "
                        + fechaAviso.getDayOfMonth() + " "
                        + fechaAviso.getMonth() + " "
                        + "?"
        ;
        log.info(expresionCron);
        CronTrigger cronTrigger = new CronTrigger(expresionCron);
        threadPoolTaskScheduler.schedule(
                new NotificacionAsincrona(
                        "cita médica",
                        event.getAgendaToEvents().getUserToAgenda().getTutorMail(),
                        "feelingcareapp@gmail.com"),
                cronTrigger
        );


    }


    protected EventService(EventRepository eventRepository) {super(eventRepository);}


}
