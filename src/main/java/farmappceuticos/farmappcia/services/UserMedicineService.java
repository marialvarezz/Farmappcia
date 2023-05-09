package farmappceuticos.farmappcia.services;


import farmappceuticos.farmappcia.model.*;
import farmappceuticos.farmappcia.repositories.MedicineRepository;
import farmappceuticos.farmappcia.repositories.UserMedicineRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Service
@Log4j2
public class UserMedicineService extends AbstractBusinessServiceSoloEnt <UserMedicine,Integer, UserMedicineRepository> {
    @Autowired
    private UserMedicineRepository userMedicineRepository;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    ThreadPoolTaskScheduler threadPoolTaskScheduler;

    public UserMedicine crearUserMedicine(UserMedicine userMedicine) {


        UserMedicine userMedicinesaved = userMedicineRepository.save(userMedicine);

         if (Boolean.TRUE.equals(userMedicinesaved.getNotificar())) {
             LocalDateTime tiempo=userMedicine.getFechainicio();

                 int numerohoras=0;

                 if (Boolean.FALSE.equals(tiempo.equals(userMedicinesaved.getFechafinal()))){
                         crearAviso(userMedicine,numerohoras);
                     numerohoras+=userMedicinesaved.getCadahoras();
                     System.out.println(tiempo);
                     tiempo.plusHours(numerohoras);
                     System.out.println(tiempo);
                     System.out.println(numerohoras);
                 }


            return userMedicinesaved;
        }
/*
       if (Boolean.TRUE.equals(eventSaved.getNotificarTutor())) {
            crearAvisoTutor(eventSaved);
        }*/

        return userMedicinesaved;

    }


    public void crearAviso(UserMedicine userMedicine, int numerohoras) {
        String expresionCron = "";


            LocalDateTime fechaAviso =
                    userMedicine.getFechainicio()
                            .plusMinutes(1)
                            .plusHours(numerohoras);


            expresionCron = "0 "
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
                            "tomate el " + userMedicine.getMedicineToMedicine().getName(),
                            userMedicine.getUserToMedicine().getEmail(),
                            "feelingcareapp@gmail.com"),
                    cronTrigger
            );
        }








/*
    public void crearAvisoTutor(Event event) {
        String expresionCron = "";

        LocalDateTime fechaAviso =
                event.getFechaHora()
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


    }*/


    protected UserMedicineService(UserMedicineRepository userMedicineRepository) {
        super(userMedicineRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD

}
