package farmappceuticos.farmappcia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Maqueta {
    @GetMapping("/")
    public String vistaInicial() {return "index2";}
    @GetMapping("/login")
    public String vistaLogin() {return "login";}
    @GetMapping("/logout")
    public String vistaLogout() {return "logout";}
    @GetMapping("/medicamentos")
    public String catMedIni() {return "catalogomedicamentosinicio";}
    @GetMapping("/incompatibles")
    public String incompatiblies() {return "incompatibilidadesmedicamentosinicio";}
    @GetMapping("/aboutus")
    public String about() {return "about";}
    @GetMapping("/contacto")
    public String contactus() {return "contacto";}
    @GetMapping("/noticias")
    public String noticias() {return "noticias";}
    @GetMapping("/hospitalescercanos")
    public String hospitales() {return "hospitales";}
    @GetMapping("/consejos")
    public String consejos() {return "consejosf";}


}
