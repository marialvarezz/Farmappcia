package farmappceuticos.farmappcia.controller;




import farmappceuticos.farmappcia.model.*;
import farmappceuticos.farmappcia.services.*;
import jakarta.validation.OverridesAttribute;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@Log4j2
@RequestMapping("/usuario")
public class UserController {
   @Autowired
   UserService1 userService;
   @Autowired
   IncMedicineService incMedicineService;

   @Autowired
   QuestionnaireService questionnaireService;
   @Autowired
   UserMedicineIncService userMedicineIncService;
   @Autowired
   MedicineService medicineService;

   @Autowired
   AgendaService agendaService;


   @Autowired
   UserMedicineService userMedicineService;

   @Autowired
   IllnessService illnessService;


   @Autowired
   EventService eventService;

   @Autowired
   MedicalHistoryService medicalHistoryService;


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

      Optional<User> tutor=userService.findByEmail(user.getTutorMail());
      if (user.getTutorMail()!=null){
         model.addAttribute("tutor",tutor.get());
      }

      List<User> tutorizados=userService.findByTutorMail(user.getEmail());
      model.addAttribute("tutorizados",tutorizados);


      return "user/userinicio";}


   @GetMapping("/historialmedico")
   public String historialMedico(Model model){
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = null;
      if (principal instanceof UserDetails) {
         userDetails = (UserDetails) principal;
      }
      String userName = userDetails.getUsername();
      User user=userService.findByName(userName);

      model.addAttribute("user",user);
      return "user/userhistorialmedico";}

   @GetMapping("/caregiver")
   public String caregiver(Model model){
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = null;
      if (principal instanceof UserDetails) {
         userDetails = (UserDetails) principal;
      }
      String userName = userDetails.getUsername();
      User user = userService.findByName(userName);
      String usernameTutor=user.getTutorMail();
      Optional<User> tutor=userService.findByEmail(usernameTutor);
      model.addAttribute("user",user);
      if (user.getTutorMail()!=null){
         model.addAttribute("tutor",tutor.get());
      }


      //Para que se impriman los usuarios de los que eres tutor
      List<User>usersGiver=userService.findByTutorMail(user.getEmail());
      model.addAttribute("usersGiver",usersGiver);

      return "user/caregiver";}

   @GetMapping("/caregiver/{id}")
   public String infocaregiver(@PathVariable("id") Integer id, Model model){
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = null;
      if (principal instanceof UserDetails) {
         userDetails = (UserDetails) principal;
      }
      String userName = userDetails.getUsername();
      User tutor = userService.findByName(userName);
      String tutorEmail=tutor.getEmail();
      Optional<User> user=userService.findById(id);
      if (user.isPresent()) {
         if (user.get().getTutorMail().equals(tutorEmail)){
            model.addAttribute("user",user.get());
            return "user/caregiver-info";
         }else {
            System.out.println(tutorEmail);
            System.out.println(user.get().getTutorMail());
            return "error-authentication";
         }

      }
         return "error";

      }

   @GetMapping("/caregiver/new")
   public String caregiverNew(Model model){
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = null;
      if (principal instanceof UserDetails) {
         userDetails = (UserDetails) principal;
      }
      String userName = userDetails.getUsername();
      User user = userService.findByName(userName);
      model.addAttribute("user",user);

      return "user/caregiver-form";}


   @PostMapping ("/caregiver/new")
   public String caregiverNew(@ModelAttribute("user") User user){
      Optional<User> userOptional=userService.findByEmail(user.getTutorMail());
      if (userOptional.isPresent()){
         userService.save(user);
         return "redirect:/usuario/caregiver";
      }else {
         System.out.println( user.getTutorMail() + "no ha sido encontrado");
         return "error";
      }


      }
   @GetMapping("/agenda")
   public String vistaAgenda(Model model) {
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = null;
      if (principal instanceof UserDetails) {
         userDetails = (UserDetails) principal;
      }
      String userName = userDetails.getUsername();
      User user=userService.findByName(userName);


      if(user.getAgendaToUser()==null) {
         Agenda agenda=new Agenda();
         agenda.setUserToAgenda(user);
         String nombre= "Agenda de " + user.getName();
         agenda.setNombre(nombre);
         model.addAttribute("agenda",agenda);
      }

      model.addAttribute("user",user);

      return "user/useragenda";}

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

   @GetMapping("/incompatibilidades")
   public String incompatibilidadesMedicamentos(Model model) {
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = null;
      if (principal instanceof UserDetails) {
         userDetails = (UserDetails) principal;
      }
      String userName = userDetails.getUsername();
      User user=userService.findByName(userName);

      List<IncMedicine>incMedicineList=incMedicineService.findAll();
      model.addAttribute("incMedicine",incMedicineList);

      model.addAttribute("user",user);
      return "user/userincompatibilidadesmedicamentos";}

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
   @PreAuthorize("hasRole('ROLE_ADMIN')")
   @GetMapping("/userlist")
   //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
   public String showProducts(Model model){
      //
      model.addAttribute("users",userService.findAll());
      //Devuelve el HTML
      return "adminUser/user-list";
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
         return "redirect:/usuario/incompatibilidades";
      }

      return "error";
   }




   @GetMapping("/medicamentosinc/delete/{id}")
   public String deleteMedicamentosInc(@PathVariable("id") Integer id) {
      userMedicineIncService.deleteById(id);
      return "redirect:/usuario/incompatibilidades";
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
      userMedicine.setHora(userMedicine.getFechainicio().getHour() + ":" + userMedicine.getFechainicio().getMinute());
      userMedicine.setDiames(userMedicine.getFechainicio().getDayOfMonth());
         userMedicine.setUserToMedicine(user);
         userMedicineService.crearUserMedicine(userMedicine);
         return "redirect:/usuario/tusmedicamentos";
      }

   @GetMapping("/medicamentos/edit/{id}")
   public String showEditMedicineForm(@PathVariable("id") Integer id, Model model) {
      Optional<UserMedicine> userMedicine = userMedicineService.findById(id);
      if (userMedicine.isPresent()) {
         List<Medicine> medicines = medicineService.findAll();
         model.addAttribute("allMedicines", medicines);
         model.addAttribute("userMedicine", userMedicine.get());
         return "medicine/user-medicine-form";
      } else {
         return "medicine/medicine-form-notfound";
      }
   }

   @GetMapping("/medicamentos/delete/{id}")
   public String deleteMedicine(@PathVariable("id") Integer id) {
      userMedicineService.deleteById(id);
      return "redirect:/usuario/tusmedicamentos";
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
      return "redirect:/usuario/historialmedico";


   }

   @PostMapping("/agenda/new")
   public String nuevaAgendaSave(@ModelAttribute("agenda") Agenda agenda) {
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = null;
      if (principal instanceof UserDetails) {
         userDetails = (UserDetails) principal;
      }
      String userName = userDetails.getUsername();
      User user = userService.findByName(userName);
      String nombre="Agenda de " + user.getName();
      agenda.setUserToAgenda(user);
      agenda.setNombre(nombre);
      agendaService.save(agenda);
      return "redirect:/usuario/agenda";


   }


   //Admin Util

   @PreAuthorize("hasRole('ROLE_ADMIN')")
   @GetMapping("/info/{id}")
   //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
   public String showuser(@PathVariable("id") Integer id, Model model){
      Optional<User> user=userService.findById(id);
      if (user.isPresent()) {

            model.addAttribute("user",user.get());
            return "adminUser/admin-user-info";

      }
      return "error";

   }

   @PreAuthorize("hasRole('ROLE_ADMIN')")
   @PostMapping("/role/{id}")
   //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
   public String rolechange(@PathVariable("id") Integer id, Model model){
      Optional<User> user=userService.findById(id);
      if (user.isPresent()) {

         model.addAttribute("user",user.get());
         return "adminUser/admin-user-info";

      }
      return "error";

   }
}
