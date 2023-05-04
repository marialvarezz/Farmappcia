package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.*;
import farmappceuticos.farmappcia.services.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
   UserService1 userService;

   @Autowired
   QuestionnaireService questionnaireService;
   @Autowired
   UserMedicineIncService userMedicineIncService;
   @Autowired
   MedicineService medicineService;

   @Autowired
   UserMedicineService userMedicineService;

   @Autowired
   IllnessService illnessService;

   @Autowired
   MedicalHistoryService medicalHistoryService;

   @Autowired
   UserDataService userDataService;


   @GetMapping({"/",""})
   public String inicioUsuario(Model model){
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = null;
      if (principal instanceof UserDetails) {
         userDetails = (UserDetails) principal;
      }
      String userName = userDetails.getUsername();
      User user=userService.findByName(userName);
      model.addAttribute("user",user);
      return "user/userinicio";}

   @GetMapping("/datosusuario")
   public String datosUsuario(){return "user/userdata";}

   @GetMapping("/historialmedico")
   public String historialMedico(){return "user/userhistorialmedico";}

   @GetMapping("/configuracion")
   public String settings(){return "user/usersettings";}

   @GetMapping("/agenda")
   public String vistaAgenda() {return "user/useragenda";}

   @GetMapping("/tusmedicamentos")
   public String tusMedicamentos(Model model) {
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = null;
      if (principal instanceof UserDetails) {
         userDetails = (UserDetails) principal;
      }
      String userName = userDetails.getUsername();
      User user=userService.findByName(userName);

      model.addAttribute("user",user);
      return "user/usertusmedicamentos";}

   @GetMapping("/medicamentos")
   public String catalogoMedicamentos(Model model) {
      List<Medicine> medicines=medicineService.findAll();
      model.addAttribute("allMedicines",medicines);
      return "user/usercatalogomedicamentos";}

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

   @GetMapping("/info/")
   public String verUsuario( Model model) {
      //Para conseguir el username del usuario autentificado
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = null;
      if (principal instanceof UserDetails) {
         userDetails = (UserDetails) principal;
      }
      String userName = userDetails.getUsername();
      User user=userService.findByName(userName);

         model.addAttribute("user", user);
         return "adminUser/user-info";
      }


   @GetMapping("/medicamentosinc/new")
   public String newUserMedicineInc( Model model) {
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = null;
      if (principal instanceof UserDetails) {
         userDetails = (UserDetails) principal;
      }
      String userName = userDetails.getUsername();
      User user=userService.findByName(userName);

         UserMedicineInc userMedicineInc = new UserMedicineInc();
         List<Medicine> medicines = medicineService.findAll();
         model.addAttribute("allMedicines", medicines);
         userMedicineInc.setUserToMedicineInc(user);
         model.addAttribute("medicineInc",userMedicineInc);
         return "adminUser/user-medicine-form";

   }
   @PostMapping("/{id}/medicamentosinc/new")
   public String createContract(@PathVariable("id") Integer id, @ModelAttribute("medicineInc") UserMedicineInc userMedicineInc){
      Optional<User> user = userService.findById(id);
      if(user.isPresent()){
         userMedicineInc.setUserToMedicineInc(user.get());
         userMedicineIncService.save(userMedicineInc);
         return "redirect:/usuario/info/";
      }

      return "error";
   }



   @GetMapping("/medicamentosinc/delete/{id}")
   public String deleteMedicamentosInc(@PathVariable("id") Integer id) {
      userMedicineIncService.deleteById(id);
      return "redirect:/usuario/info/";
   }

   @GetMapping("/medicamentos/new")
   public String nuevoMedicamento(Model model) {
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = null;
      if (principal instanceof UserDetails) {
         userDetails = (UserDetails) principal;
      }
      String userName = userDetails.getUsername();
      User user=userService.findByName(userName);


         UserMedicine userMedicine = new UserMedicine();
         List<Medicine> medicines = medicineService.findAll();
         model.addAttribute("allMedicines", medicines);
         userMedicine.setUserToMedicine(user);
         model.addAttribute("userMedicine",userMedicine);
         return "medicine/user-medicine-form";

   }

   @PostMapping("/medicamentos/new")
   public String nuevoParteSave( @ModelAttribute("userMedicine") UserMedicine userMedicine){
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = null;
      if (principal instanceof UserDetails) {
         userDetails = (UserDetails) principal;
      }
      String userName = userDetails.getUsername();
      User user=userService.findByName(userName);


         userMedicine.setUserToMedicine(user);
         userMedicineService.save(userMedicine);
         return "redirect:/usuario/info/";
      }


   @GetMapping("/historialmedico/new")
   public String nuevoParte( Model model) {
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = null;
      if (principal instanceof UserDetails) {
         userDetails = (UserDetails) principal;
      }
      String userName = userDetails.getUsername();
      User user=userService.findByName(userName);

         MedicalHistory medicalHistory = new MedicalHistory();
         List<Illness> illnessList = illnessService.findAll();
         model.addAttribute("allIllness", illnessList);
         medicalHistory.setUser(user);
         model.addAttribute("medicalhistory",medicalHistory);
         return "medicalHistory/medicalHistoryUser-form";
      }



   @PostMapping("/historialmedico/new")
   public String nuevoParteSave( @ModelAttribute("medicalhistory") MedicalHistory medicalHistory) {
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = null;
      if (principal instanceof UserDetails) {
         userDetails = (UserDetails) principal;
      }
      String userName = userDetails.getUsername();
      User user = userService.findByName(userName);
      medicalHistory.setUser(user);
      medicalHistoryService.save(medicalHistory);
      return "redirect:/usuario/info/";

   }

   @GetMapping("/datosusuario/new")
   public String datosusuarionew( Model model) {

      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = null;
      if (principal instanceof UserDetails) {
         userDetails = (UserDetails) principal;
      }
      String userName = userDetails.getUsername();
      User user=userService.findByName(userName);


      UserData userData = new UserData();
      userData.setUserToUserData(user);
      model.addAttribute("userdata",userData);
      return "userData/userData-User-form";
   }



   @PostMapping("/datosusuario/new")
   public String datosusuarionew(@ModelAttribute("userdata") UserData userData) {

      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = null;
      if (principal instanceof UserDetails) {
         userDetails = (UserDetails) principal;
      }
      String userName = userDetails.getUsername();
      User user = userService.findByName(userName);


      userData.setUserToUserData(user);
      userDataService.save(userData);
      return "redirect:/usuario/info/";

   }

}
