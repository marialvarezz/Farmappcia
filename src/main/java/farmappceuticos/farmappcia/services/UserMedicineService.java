package farmappceuticos.farmappcia.services;


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

        Integer i = 0;
        while (i < veces) {
            System.out.println(userMedicine.getFechainicio());
            if (Boolean.TRUE.equals(userMedicine.getNotificar())) {
                crearAviso(userMedicine);
            }
            userMedicine.setFechainicio(userMedicine.getFechainicio().plusHours(userMedicine.getCadahoras()));

            i++;
        }
        UserMedicine userMedicinesaved = userMedicineRepository.save(userMedicine);
        return userMedicinesaved;
    }

/*
       if (Boolean.TRUE.equals(eventSaved.getNotificarTutor())) {
            crearAvisoTutor(eventSaved);
        }*/






    public void crearAviso(UserMedicine userMedicine) {
        String expresionCron = "";

        LocalDateTime fechaAviso =
                userMedicine.getFechainicio();


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
                        "Tomate el medicamento: " + userMedicine.getMedicineToMedicine().getName(),
                        userMedicine.getUserToMedicine().getEmail(),
                        "feelingcareapp@gmail.com"),
                cronTrigger
        );


    }









    public void crearAvisoTutor(UserMedicine userMedicine) {
        String expresionCron = "";

        LocalDateTime fechaAviso =
                userMedicine.getFechainicio();


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
                        userMedicine.getUserToMedicine().getEmail() + " tiene que tomarse el medicamento:" + userMedicine.getMedicineToMedicine().getName(),
                        userMedicine.getUserToMedicine().getTutorMail(),
                        "feelingcareapp@gmail.com"),
                cronTrigger
        );


    }


    protected UserMedicineService(UserMedicineRepository userMedicineRepository) {
        super(userMedicineRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD

}
