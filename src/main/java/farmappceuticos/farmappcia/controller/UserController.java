package farmappceuticos.farmappcia.controller;




import com.itextpdf.text.DocumentException;
import farmappceuticos.farmappcia.dto.UserDto;
import farmappceuticos.farmappcia.model.*;
import farmappceuticos.farmappcia.services.*;
import farmappceuticos.farmappcia.util.SearchFromData;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
   QuestionQuestionnaireService questionQuestionnaireService;

   @Autowired
   EventService eventService;

   @Autowired
   UserDataService userDataService;



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
      System.out.println(tutorizados.isEmpty());
      model.addAttribute("tutorizados",tutorizados);


      return "user/userinicio";}


   @GetMapping("/historialmedico")
   public String historialMedico(Model model,
                                 @RequestParam("page")Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size){
      User user=getUserAuten();


      int currentPage = page.orElse(1);
      int pageSize = size.orElse(10);

      Page<MedicalHistory> medicalHistories = medicalHistoryService.findByUser(user,PageRequest.of(currentPage - 1, pageSize));
      model.addAttribute("medicalHistoryPage", medicalHistories);
      int totalPages = medicalHistories.getTotalPages();
      if (totalPages > 0){
         List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                 .boxed()
                 .collect(Collectors.toList());
         model.addAttribute("pageNumbers", pageNumbers);
      }
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
   public String catalogoMedicamentos(Model model, @RequestParam("page")Optional<Integer> page,
                                      @RequestParam("size") Optional<Integer> size
                                      ) {
      model.addAttribute("medicine",medicineService.findAll());
      SearchFromData searchFormData=new SearchFromData();
      int currentPage = page.orElse(1);
      int pageSize = size.orElse(15);

      Page<Medicine> medicinePage = medicineService.findAll(PageRequest.of(currentPage - 1, pageSize));

      String filtroLista = "";
      model.addAttribute("filtroLista", filtroLista);
      model.addAttribute("searchFormData", searchFormData);
      model.addAttribute("medicinePage", medicinePage);
      int totalPages = medicinePage.getTotalPages();
      if (totalPages > 0){
         List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                 .boxed()
                 .collect(Collectors.toList());
         model.addAttribute("pageNumbers", pageNumbers);
      }
      //Devuelve el HTML
      return "user/usercatalogomedicamentos";
   }

   @PostMapping("/medicamentos/")
   public String medicines(Model model,@ModelAttribute("searchFormData") SearchFromData searchFromData,
                           @RequestParam("page")Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size){

      model.addAttribute("medicine",medicineService.findAll());
      int currentPage = page.orElse(1);
      int pageSize = size.orElse(15);
      Page<Medicine>medicinePage;
      if (searchFromData.getSearchText()==""){
         medicinePage = medicineService.findAll(PageRequest.of(currentPage - 1, pageSize));
      }else {
         medicinePage=medicineService.findByName(searchFromData.getSearchText(),PageRequest.of(currentPage - 1, pageSize));
      }
      String filtroLista = "";
      model.addAttribute("filtroLista", searchFromData.getSearchText());
      model.addAttribute("medicinePage", medicinePage);
      int totalPages = medicinePage.getTotalPages();
      if (totalPages > 0){
         List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                 .boxed()
                 .collect(Collectors.toList());
         model.addAttribute("pageNumbers", pageNumbers);
      }
      return "user/usercatalogomedicamentos";
   }




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




   //Cuestionarios
   @GetMapping("/cuestionarios")
   public String showQuestionnaire(Model model){
      model.addAttribute("questionnaires",questionnaireService.findAll());
    User user=getUserAuten();
      model.addAttribute("user",user);

      //Devuelve el HTML
      return "questionnaire/questionnaire-list";
   }


   @GetMapping("/respuestas")
   public String showAnswers(Model model){
      model.addAttribute("questionnaires",questionnaireService.findAll());
      User user=getUserAuten();
      model.addAttribute("user",user);
      //Devuelve el HTML
      return "questionnaire/answers-list";
   }

   //CRUD User
   @PreAuthorize("hasRole('ROLE_ADMIN')")
   @GetMapping("/userlist")
   //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
   public String showProducts(Model model,
                              @RequestParam("page")Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size){
     

      model.addAttribute("user",userService.findAll());


      int currentPage = page.orElse(1);
      int pageSize = size.orElse(5);

      Page<User> userPage = userService.findAll(PageRequest.of(currentPage - 1, pageSize));

      model.addAttribute("userPage", userPage);
      int totalPages = userPage.getTotalPages();
      if (totalPages > 0){
         List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                 .boxed()
                 .collect(Collectors.toList());
         model.addAttribute("pageNumbers", pageNumbers);
      }
      model.addAttribute("users",userService.findAll());
      //Devuelve el HTML
      return "adminUser/user-list";
   }

   @PostMapping("/save")
   public String saveProduct(@ModelAttribute("user") User user) {
      userService.guardarUs(user);
      return "redirect:/usuario/info/";
   }

   @PreAuthorize("hasRole('ROLE_ADMIN')")
   @GetMapping("/edit/{id}")
   public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
      model.addAttribute("user", userService.findById(id));
      return "adminUser/user-form";
   }


   @GetMapping("/edit/")
   public String showEditProductForm( Model model) {
      User user=getUserAuten();
      model.addAttribute("user", user);
      return "adminUser/user-form";
   }

   @GetMapping("/datosusuario/new")
   public String dataUser( Model model) {
      User user=getUserAuten();
      UserData userData=new UserData();
      userData.setUserToUserData(user);
      model.addAttribute("datos",userData);
      return "dataUser/dataUser-form";
   }

   @GetMapping("/datosusuario/edit")
   public String dataEditUser( Model model) {
      User user=getUserAuten();

      model.addAttribute("datos",user.getUserDataToUser());
      return "dataUser/dataUser-form";
   }
   @PostMapping("/datosusuario/new")
   public String dataUserSave(@ModelAttribute("datos") UserData userData, Model model) {
      User user=getUserAuten();
      userData.setUserToUserData(user);
      userData.setFechaInsert(LocalDateTime.now());
      userDataService.save(userData);
      return "redirect:/usuario/info/";
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

   private User getUserAuten(){
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      UserDetails userDetails = null;
      if (principal instanceof UserDetails) {
         userDetails = (UserDetails) principal;
      }
      String userName = userDetails.getUsername();
      User user=userService.findByName(userName);
      return user;
   }


}
