package farmappceuticos.farmappcia.controller;

import clojure.lang.IFn;
import farmappceuticos.farmappcia.model.*;
import farmappceuticos.farmappcia.services.*;
import farmappceuticos.farmappcia.util.SearchFromData;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Log4j2
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService1 userService;
    @Autowired
    private MedicineService medicineService;
    @Autowired
    private EventService eventService;
    @Autowired
    private IncMedicineService incMedicineService;
    @Autowired
    private IllnessService illnessService;
    @Autowired
    private QuestionnaireService questionnaireService;
    @Autowired
    private QuestionsService questionsService;


    @GetMapping({"/", ""})
    public String inicioAdmin(Model model){

        User user=getUserAuten();
        model.addAttribute("user",user);
        List<User>userList=userService.findAll();
        model.addAttribute("numUsu",userList.size());
        List<Medicine> medicines=medicineService.findAll();
        model.addAttribute("numMedicine",medicines.size());
        List<IncMedicine>incMedicineList=incMedicineService.findAll();
        model.addAttribute("numIncMedicine",incMedicineList.size());
        List<Illness>illnesses=illnessService.findAll();
        model.addAttribute("numIllness",illnesses.size());
        List<Questionnaire> questionnaires=questionnaireService.findAll();
        model.addAttribute("numQuestionnaire",questionnaires.size());
        List<Questions>questions=questionsService.findAll();
        model.addAttribute("numQuestion",questions.size());
        return "adminUser/admininicio";
    }

    @GetMapping("/userlist")
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showProducts(Model model,
                               @RequestParam("page")Optional<Integer> page,
                               @RequestParam("size") Optional<Integer> size){

        //
        model.addAttribute("user", userService.findAll());

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<User> userPage = userService.findAll(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("userPAge", userPage);
        int totalPages = userPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
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
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "adminUser/user-info";
        }
        return "error";
    }

    @GetMapping({"/medicamentos/"})
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showMedicines(Model model,
                                @RequestParam("page")Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size) {
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
        return "medicine/admin-medicine-list";
    }

    @PostMapping("/medicamentos/")
    public String showMedi(Model model,
                           @ModelAttribute("searchFormData") SearchFromData searchFromData,
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
        model.addAttribute("filtroLista", searchFromData.getSearchText());
        model.addAttribute("medicinePage", medicinePage);
        int totalPages = medicinePage.getTotalPages();
        if (totalPages > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "medicine/admin-medicine-list";
    }

    @GetMapping("/eventos/")
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showEvents(Model model){
        //
        model.addAttribute("event",eventService.findAll());
        //Devuelve el HTML
        return "event/event-list";
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
