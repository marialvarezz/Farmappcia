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
   public String inicioUsuario(){return "userinicio";}

   @GetMapping("/datosusuario")
   public String datosUsuario(){return "userdata";}

   @GetMapping("/historialmedico")
   public String historialMedico(){return "userhistorialmedico";}

   @GetMapping("/configuracion")
   public String settings(){return "usersettings";}

   @GetMapping("/agenda")
   public String vistaAgenda() {return "useragenda";}

   @GetMapping("/tusmedicamentos")
   public String tusMedicamentos() {return "usertusmedicamentos";}

   @GetMapping("/catalogomedicamentos")
   public String catalogoMedicamentos() {return "usercatalogomedicamentos";}

   @GetMapping("/incompatibilidadesmedicamentos")
   public String incompatibilidadesMedicamentos() {return "userincompatibilidadesmedicamentos";}

   @GetMapping("/medicamentosfavoritos")
   public String medicamentosFavoritos() {return "usermedicamentosfavoritos";}
   @GetMapping("/aboutus")
   public String aboutUser() {return "userabout";}
   @GetMapping("/contacto")
   public String contactusUser() {return "usercontacto";}
   @GetMapping("/noticias")
   public String noticiasUser() {return "usernoticias";}
   @GetMapping("/hospitalescercanos")
   public String hospitalesUser() {return "userhospitales";}
   @GetMapping("/consejos")
   public String consejosUser() {return "userconsejosf";}
}
