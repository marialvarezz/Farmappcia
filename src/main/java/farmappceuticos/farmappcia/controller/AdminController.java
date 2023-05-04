package farmappceuticos.farmappcia.controller;

import farmappceuticos.farmappcia.model.User;
import farmappceuticos.farmappcia.services.UserService1;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@Log4j2
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService1 userService;

    @GetMapping({"/",""})
    public String inicioAdmin(){return "adminUser/admininicio";}

    @GetMapping("/userlist")
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showProducts(Model model){
        //
        model.addAttribute("user",userService.findAll());
        //Devuelve el HTML
        return "adminUser/user-list";
    }
    @GetMapping("/usuario/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "adminUser/user-form";
    }
    @GetMapping("/usuario/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return "redirect:/usuario/userlist";
    }

    @GetMapping("/usuario/info/{id}")
    public String verUsuario(@PathVariable("id") Integer id, Model model) {
        Optional<User> user=userService.findById(id);
        if (user.isPresent()){
            model.addAttribute("user", user.get());
            return "adminUser/user-info";
        }
        return "error";
    }


}
