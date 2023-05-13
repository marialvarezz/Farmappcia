package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.Medicine;
import farmappceuticos.farmappcia.model.Questions;
import farmappceuticos.farmappcia.model.User;
import farmappceuticos.farmappcia.model.UserMedicineInc;
import farmappceuticos.farmappcia.services.MedicineService;
import farmappceuticos.farmappcia.services.QuestionsService;
import farmappceuticos.farmappcia.services.UserMedicineIncService;
import farmappceuticos.farmappcia.services.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @Autowired
    private UserService1 userService;
    //Para acceder a los métodos

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping({"/",""})
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showProducts(Model model){
        //
        model.addAttribute("userMedicineInc",userMedicineIncService.findAll());
        //Devuelve el HTML
        return "userMedicineInc/userMedicineInc-list";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("userMedicineInc") UserMedicineInc userMedicineInc) {
        userMedicineIncService.save(userMedicineInc);
        return "redirect:/usuario/incompatibilidades";
    }
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String userName = userDetails.getUsername();
        User userAut = userService.findByName(userName);

        Optional<UserMedicineInc> userMedicineInc = userMedicineIncService.findById(id);
        if (userMedicineInc.isPresent()){
            User user=userMedicineInc.get().getUserToMedicineInc();
            if (userAut==user){
                List<Medicine> medicines = medicineService.findAll();
                model.addAttribute("allMedicines", medicines);
                model.addAttribute("medicineInc", userMedicineInc.get());
                return "userMedicineInc/userMedicineInc-form";
            }else {
                return "error-authentication";
            }

        }
        else {
            return "userMedicineInc/userMedicineInc-form-notfound";
        }
    }

    //TODO falta el PostMapping
    //Cuidado solo es un ejmplo, no borramos ficicamente

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String userName = userDetails.getUsername();
        User userAut = userService.findByName(userName);

        Optional<UserMedicineInc> userMedicineInc = userMedicineIncService.findById(id);
        if (userMedicineInc.isPresent()){
            User user=userMedicineInc.get().getUserToMedicineInc();
            if (userAut==user){
                userMedicineIncService.deleteById(id);
                return "redirect:/usuario/incompatibilidades";
            }
        else {
            return "error-authentication";
            }}
        return "error";

    }

}
