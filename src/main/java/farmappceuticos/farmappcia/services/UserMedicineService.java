package farmappceuticos.farmappcia.services;


import farmappceuticos.farmappcia.dto.Email;
import farmappceuticos.farmappcia.model.*;
import farmappceuticos.farmappcia.repositories.MedicineRepository;
import farmappceuticos.farmappcia.repositories.UserMedicineRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Log4j2
public class UserMedicineService extends AbstractBusinessServiceSoloEnt <UserMedicine,Integer, UserMedicineRepository> {
    @Autowired
    private UserMedicineRepository userMedicineRepository;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    ThreadPoolTaskScheduler threadPoolTaskScheduler;

    public UserMedicine crearUserMedicine(UserMedicine userMedicine) {

        Duration res = Duration.between(userMedicine.getFechainicio(), userMedicine.getFechafinal());
        Long segundos = res.getSeconds();
        Long horas = segundos / 3600;
        Long veces = horas / userMedicine.getCadahoras();
        List<LocalDateTime>meme=new ArrayList<>();
        Integer i = 0;
        userMedicine.setMomento(userMedicine.getFechainicio());
        while (i < veces) {
            System.out.println(userMedicine.getMomento());
            if (Boolean.TRUE.equals(userMedicine.getNotificar())) {
                crearAviso(userMedicine);
                if (Boolean.TRUE.equals(userMedicine.getNotificarTutor())) {
                    crearAvisoTutor(userMedicine);
                }
            }
            meme.add(userMedicine.getMomento());
            LocalDateTime mm=userMedicine.getMomento();
            mm=mm.plusHours(userMedicine.getCadahoras());
                userMedicine.setMomento(mm);
            i++;
        }
        userMedicine.setMomentos(meme);
        UserMedicine userMedicinesaved = userMedicineRepository.save(userMedicine);
        return userMedicinesaved;
    }








    public void crearAviso(UserMedicine userMedicine) {
        String expresionCron = "";

        LocalDateTime fechaAviso =
                userMedicine.getMomento();


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
        String subject="Hora de toma el medicamento: " + userMedicine.getMedicineToMedicine().getName();
        String contenido="Te toca tomar el medicamento: " + userMedicine.getMedicineToMedicine().getName() + " a las " + userMedicine.getHora();
        String destinatario=userMedicine.getUserToMedicine().getEmail();
        String rtente="notificaciones@agestturnos.es";
        Email email=new Email(subject,contenido,destinatario,rtente);
        threadPoolTaskScheduler.schedule(
                new NotificacionAsincrona(
                        email),
                cronTrigger
        );


    }









    public void crearAvisoTutor(UserMedicine userMedicine) {
        String expresionCron = "";

        LocalDateTime fechaAviso =
                userMedicine.getMomento();


        expresionCron =
                "0 "
                        + fechaAviso.getMinute() + " "
                        + fechaAviso.getHour() + " "
                        + fechaAviso.getDayOfMonth() + " "
                        + fechaAviso.getMonth() + " "
                        + "?"
        ;
        String subject="Hora de toma el medicamento: " + userMedicine.getMedicineToMedicine().getName();
        String contenido="A "+userMedicine.getUserToMedicine().getName()+ " le toca tomar el medicamento: " + userMedicine.getMedicineToMedicine().getName();
        String destinatario=userMedicine.getUserToMedicine().getTutorMail();
        String rtente="notificaciones@agestturnos.es";
        Email email=new Email(subject,contenido,destinatario,rtente);
        log.info(expresionCron);
        CronTrigger cronTrigger = new CronTrigger(expresionCron);
        threadPoolTaskScheduler.schedule(
                new NotificacionAsincrona(email
                ),
                cronTrigger
        );


    }


    protected UserMedicineService(UserMedicineRepository userMedicineRepository) {
        super(userMedicineRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD

}
