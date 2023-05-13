package farmappceuticos.farmappcia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Email {


    private String subject;
    private String message;
    private String destinatario;
    private String remitente;
}
