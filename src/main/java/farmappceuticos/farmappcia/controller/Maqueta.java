package farmappceuticos.farmappcia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Maqueta {
    @GetMapping("/")
    public String vistaInicial() {return "index";}
    @GetMapping("/login")
    public String vistaLogin() {return "login";}
    @GetMapping("/usuarios/logout")
    public String vistaLogout() {return "logout";}
    @GetMapping("/usuarios/historialmedico")
    public String vistaHistorialMedico() {return "historialmedico";}
    @GetMapping("/usuarios/datosdelusuario")
    public String vistaDatosDelUsuario() {return "datosdelusuario";}
    @GetMapping("/agenda")
    public String vistaAgenda() {return "agenda";}
}
