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


}
