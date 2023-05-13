package farmappceuticos.farmappcia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificacionAsincrona implements Runnable{


    private String message;
    private String destinatario;
    private String remitente;


    @Override
    public void run() {

        System.out.println(remitente + " ha enviado un email al " + destinatario + " : " + message);

    }

}
