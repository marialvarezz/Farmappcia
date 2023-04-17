package farmappceuticos.farmappcia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Maqueta {
    @GetMapping("/")
    public String vistaInicial() {return "home/paginaInicio2";}
    @GetMapping("/login")
    public String vistaLogin() {return "home/login";}
    @GetMapping("/logout")
    public String vistaLogout() {return "home/logout";}
    @GetMapping("/medicamentos")
    public String catMedIni() {return "home/catalogomedicamentosinicio";}
    @GetMapping("/incompatibles")
    public String incompatiblies() {return "home/incompatibilidadesmedicamentosinicio";}
    @GetMapping("/aboutus")
    public String about() {return "home/about";}
    @GetMapping("/contacto")
    public String contactus() {return "home/contacto";}
    @GetMapping("/noticias")
    public String noticias() {return "home/noticias";}
    @GetMapping("/hospitalescercanos")
    public String hospitales() {return "home/hospitales";}
    @GetMapping("/consejos")
    public String consejos() {return "home/consejosf";}


}
