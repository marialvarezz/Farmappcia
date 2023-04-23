package farmappceuticos.farmappcia.controller;

import farmappceuticos.farmappcia.model.Medicine;
import farmappceuticos.farmappcia.model.Questions;
import farmappceuticos.farmappcia.model.User;
import farmappceuticos.farmappcia.model.UserMedicineInc;
import farmappceuticos.farmappcia.services.MedicineService;
import farmappceuticos.farmappcia.services.QuestionnaireService;
import farmappceuticos.farmappcia.services.UserMedicineIncService;
import farmappceuticos.farmappcia.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@Log4j2
@RequestMapping("/usuario")
public class UserController {
   @Autowired
   UserService userService;

   @Autowired
   QuestionnaireService questionnaireService;
   @Autowired
   UserMedicineIncService userMedicineIncService;
   @Autowired
   MedicineService medicineService;

   @GetMapping({"/",""})
   public String inicioUsuario(){return "user/userinicio";}

   @GetMapping("/datosusuario")
   public String datosUsuario(){return "user/userdata";}

   @GetMapping("/historialmedico")
   public String historialMedico(){return "user/userhistorialmedico";}

   @GetMapping("/configuracion")
   public String settings(){return "user/usersettings";}

   @GetMapping("/agenda")
   public String vistaAgenda() {return "user/useragenda";}

   @GetMapping("/tusmedicamentos")
   public String tusMedicamentos() {return "user/usertusmedicamentos";}

   @GetMapping("/catalogomedicamentos")
   public String catalogoMedicamentos() {return "user/usercatalogomedicamentos";}

   @GetMapping("/incompatibilidadesmedicamentos")
   public String incompatibilidadesMedicamentos() {return "user/userincompatibilidadesmedicamentos";}

   @GetMapping("/medicamentosfavoritos")
   public String medicamentosFavoritos() {return "user/usermedicamentosfavoritos";}
   @GetMapping("/aboutus")
   public String aboutUser() {return "user/userabout";}
   @GetMapping("/contacto")
   public String contactusUser() {return "user/usercontacto";}
   @GetMapping("/noticias")
   public String noticiasUser() {return "user/usernoticias";}
   @GetMapping("/hospitalescercanos")
   public String hospitalesUser() {return "user/userhospitales";}
   @GetMapping("/consejos")
   public String consejosUser() {return "user/userconsejosf";}


   //Cuestionarios
   @GetMapping("/cuestionarios")
   public String showQuestionnaire(Model model){
      model.addAttribute("questionnaires",questionnaireService.findAll());
      //Devuelve el HTML
      return "questionnaire/questionnaire-list";
   }

   //CRUD User
   @GetMapping("/userlist")
   //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
   public String showProducts(Model model){
      //
      model.addAttribute("user",userService.findAll());
      //Devuelve el HTML
      return "adminUser/user-list";
   }
   @GetMapping("/new")
   public String showNewProductForm(Model model) {
      model.addAttribute("user",new User());
      return "adminUser/user-form";
   }
   @PostMapping("/save")
   public String saveProduct(@ModelAttribute("user") User user) {
      userService.save(user);
      return "redirect:/usuario/userlist";
   }
   @GetMapping("/edit/{id}")
   public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
      model.addAttribute("user", userService.findById(id));
      return "adminUser/user-form";
   }
   @GetMapping("/delete/{id}")
   public String deleteProduct(@PathVariable("id") Integer id) {
      userService.deleteById(id);
      return "redirect:/usuario/userlist";
   }

   @GetMapping("/info/{id}")
   public String verUsuario(@PathVariable("id") Integer id, Model model) {
      Optional<User> user=userService.findById(id);
      if (user.isPresent()){
         model.addAttribute("user", user.get());
         return "adminUser/user-info";
      }
      return "error";
   }

   @GetMapping("/{id}/medicamentosinc/new")
   public String newUserMedicineInc(@PathVariable("id") Integer id, Model model) {
      Optional<User> user = userService.findById(id);
      if (user.isPresent()) {
         UserMedicineInc userMedicineInc = new UserMedicineInc();
         List<Medicine> medicines = medicineService.findAll();
         model.addAttribute("allMedicines", medicines);
         userMedicineInc.setUserToMedicineInc(user.get());
         model.addAttribute("medicineInc",userMedicineInc);
         return "adminUser/user-medicine-form";
      } else {
         return "error-page";
      }
   }
   @PostMapping("/{id}/medicamentosinc/new")
   public String createContract(@PathVariable("id") Integer id, @ModelAttribute("medicineInc") UserMedicineInc userMedicineInc){
      Optional<User> user = userService.findById(id);
      if(user.isPresent()){
         userMedicineInc.setUserToMedicineInc(user.get());
         userMedicineIncService.save(userMedicineInc);
         return "redirect:/usuario/info/"+id;
      }

      return "error";
   }
}
