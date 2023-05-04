package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.Illness;
import farmappceuticos.farmappcia.model.UserData;
import farmappceuticos.farmappcia.services.IllnessService;
import farmappceuticos.farmappcia.services.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping("/datosusuario")//url
public class DataUserController {
    @Autowired
    private UserDataService userDataService;
    //Para acceder a los métodos

    @GetMapping({"/",""})
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showIllness(Model model){
        //
        model.addAttribute("userdata",userDataService.findAll());
        //Devuelve el HTML
        return "userData/userData-list";
    }
    @GetMapping("/new")
    public String showNewUserDataForm(Model model) {
        model.addAttribute("userdata", new UserData());
        return "userData/userData-form";
    }
    @PostMapping("/save")
    public String saveIllness(@ModelAttribute("userdata") UserData userData)  {
        userData.setFechaInsert(LocalDateTime.now());
        userDataService.save(userData);
        return "redirect:/usuario/info";
    }
    @GetMapping("/edit/{id}")
    public String showEditIllnessForm(@PathVariable("id") Integer id, Model model) {
        Optional<UserData> userData = userDataService.findById(id);
        if (userData.isPresent()){
            model.addAttribute("userdata", userData.get());
            return "userData/userData-form";
        }
        else {
            return "error";
        }
    }

    //TODO falta el PostMapping
    //Cuidado solo es un ejemplo, no borramos fisicamente
    @GetMapping("/delete/{id}")
    public String deleteIllness(@PathVariable("id") Integer id) {
        userDataService.deleteById(id);
        return "redirect:/usuario/info";
    }

}
