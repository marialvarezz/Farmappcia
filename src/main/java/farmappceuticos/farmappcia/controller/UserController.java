package farmappceuticos.farmappcia.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/usuario")
public class UserController {
   @GetMapping("/")
   public String inicioUsuario(){return "user/userinicio";}

   @GetMapping("/datosusuario")
   public String datosUsuario(){return "user/userdata";}

   @GetMapping("/historialmedico")
   public String historialMedico(){return "user/userhistorialmedico";}

   @GetMapping("/configuracion")
   public String settings(){return "user/usersettings";}

   @GetMapping("/agenda")
   public String vistaAgenda() {return "user/useragenda";}

   @GetMapping("/tusmedicamentos")
   public String tusMedicamentos() {return "user/usertusmedicamentos";}

   @GetMapping("/catalogomedicamentos")
   public String catalogoMedicamentos() {return "user/usercatalogomedicamentos";}

   @GetMapping("/incompatibilidadesmedicamentos")
   public String incompatibilidadesMedicamentos() {return "user/userincompatibilidadesmedicamentos";}

   @GetMapping("/medicamentosfavoritos")
   public String medicamentosFavoritos() {return "user/usermedicamentosfavoritos";}
   @GetMapping("/aboutus")
   public String aboutUser() {return "user/userabout";}
   @GetMapping("/contacto")
   public String contactusUser() {return "user/usercontacto";}
   @GetMapping("/noticias")
   public String noticiasUser() {return "user/usernoticias";}
   @GetMapping("/hospitalescercanos")
   public String hospitalesUser() {return "user/userhospitales";}
   @GetMapping("/consejos")
   public String consejosUser() {return "user/userconsejosf";}
}
