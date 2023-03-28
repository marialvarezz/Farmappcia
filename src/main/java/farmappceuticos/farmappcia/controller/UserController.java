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
   public String inicioUsuario(){return "inicioUsuario";}

   @GetMapping("/datosusuario")
   public String datosUsuario(){return "datosdelusuario";}

   @GetMapping("/historialmedico")
   public String historialMedico(){return "historialmedico";}

   @GetMapping("/configuracion")
   public String settings(){return "settings";}

   @GetMapping("/agenda")
   public String vistaAgenda() {return "agenda";}

   @GetMapping("/tusmedicamentos")
   public String tusMedicamentos() {return "tusmedicamentos";}

   @GetMapping("/catalogomedicamentos")
   public String catalogoMedicamentos() {return "catalogomedicamentos";}

   @GetMapping("/incompatibilidadesmedicamentos")
   public String incompatibilidadesMedicamentos() {return "incompatibilidadesmedicamentos";}

   @GetMapping("/medicamentosfavoritos")
   public String medicamentosFavoritos() {return "medicamentosfavoritos";}
}
