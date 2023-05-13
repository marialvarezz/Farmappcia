package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.dto.Email;
import farmappceuticos.farmappcia.model.Agenda;
import farmappceuticos.farmappcia.model.Event;
import farmappceuticos.farmappcia.model.NotificacionAsincrona;
import farmappceuticos.farmappcia.repositories.EventRepository;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Properties;


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
        String subject="Recordatorio de: " + event.getNombre();
        String contenido="Tienes un evento programado: " + event.getNombre() + " en " +
                event.getEspecializacion() + " de " + event.getUbicacion() + " el día " + event.getFechahora().getDayOfMonth() + "/"+ event.getFechahora().getMonthValue() + " a las: " + event.getHora();
        String destinatario=event.getAgendaToEvents().getUserToAgenda().getEmail();
        String rtente="notificaciones@agestturnos.es";
        Email email=new Email(subject,contenido,destinatario,rtente);
      threadPoolTaskScheduler.schedule(
                new NotificacionAsincrona(
                        email),
                cronTrigger
        );


    }

    private Session session;
    public void initSesion(){
        //provide Mailtrap's username
        final String username = "api";
        //provide Mailtrap's password
        final String password = "b411b9132ea86b8cb2cbada15bfcbfd1";
        //provide Mailtrap's host address
        String host = "live.smtp.mailtrap.io";
        //configure Mailtrap's SMTP server details
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        //create the Session object
        session = Session.getInstance(props,
                new jakarta.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
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
        String subject="Recordatorio de: " + event.getNombre();
        String contenido= event.getAgendaToEvents().getUserToAgenda().getName()+ " tiene un evento programado: " + event.getNombre() + " en " +
                event.getEspecializacion() + " de " + event.getUbicacion() + " el día " + event.getFechahora().getDayOfMonth() + "/"+ event.getFechahora().getMonthValue()  + " a las " + event.getHora();
        String destinatario=event.getAgendaToEvents().getUserToAgenda().getTutorMail();
        String rtente="notificaciones@agestturnos.es";
        Email email=new Email(event.getNombre(),contenido,destinatario,rtente);
        log.info(expresionCron);
        CronTrigger cronTrigger = new CronTrigger(expresionCron);
        threadPoolTaskScheduler.schedule(
               new NotificacionAsincrona(email),
                cronTrigger
        );


    }




    protected EventService(EventRepository eventRepository) {super(eventRepository);}


}
