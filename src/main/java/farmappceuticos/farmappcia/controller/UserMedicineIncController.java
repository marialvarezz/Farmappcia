package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.Medicine;
import farmappceuticos.farmappcia.model.Questions;
import farmappceuticos.farmappcia.model.UserMedicineInc;
import farmappceuticos.farmappcia.services.MedicineService;
import farmappceuticos.farmappcia.services.QuestionsService;
import farmappceuticos.farmappcia.services.UserMedicineIncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usumedicamentosinc")//url
public class UserMedicineIncController {
    @Autowired
    private UserMedicineIncService userMedicineIncService;
    @Autowired
    private MedicineService medicineService;
    //Para acceder a los métodos

    @GetMapping({"/",""})
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showProducts(Model model){
        //
        model.addAttribute("userMedicineInc",userMedicineIncService.findAll());
        //Devuelve el HTML
        return "userMedicineInc/userMedicineInc-list";
    }
    @GetMapping("/new")
    public String showNewProductForm(Model model) {
        model.addAttribute("userMedicineInc", new UserMedicineInc());
        return "userMedicineInc/userMedicineInc-form";
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("userMedicineInc") UserMedicineInc userMedicineInc) {
        userMedicineIncService.save(userMedicineInc);
        return "redirect:/usuario/userlist";
    }
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
        Optional<UserMedicineInc> userMedicineInc = userMedicineIncService.findById(id);
        if (userMedicineInc.isPresent()){
            List<Medicine> medicines = medicineService.findAll();
            model.addAttribute("allMedicines", medicines);
            model.addAttribute("medicineInc", userMedicineInc.get());
            return "userMedicineInc/userMedicineInc-form";
        }
        else {
            return "userMedicineInc/userMedicineInc-form-notfound";
        }
    }

    //TODO falta el PostMapping
    //Cuidado solo es un ejmplo, no borramos ficicamente
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        userMedicineIncService.deleteById(id);
        return "redirect:/usumedicamentosinc/";
    }

}
