package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.Illness;
import farmappceuticos.farmappcia.model.MedicalHistory;
import farmappceuticos.farmappcia.model.User;
import farmappceuticos.farmappcia.model.UserMedicineInc;
import farmappceuticos.farmappcia.services.IllnessService;
import farmappceuticos.farmappcia.services.MedicalHistoryService;
import farmappceuticos.farmappcia.services.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/historialmedico")//url
public class MedicalHistoryController {
    @Autowired
    private MedicalHistoryService medicalHistoryService;

    @Autowired
    private IllnessService illnessService;

    @Autowired
    private UserService1 userService;
    //Para acceder a los métodos

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping({"/",""})
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showMedicalHistory(Model model,
                                     @RequestParam("page")Optional<Integer> page,
                                     @RequestParam("size") Optional<Integer> size){
        //
        model.addAttribute("medicalHistory",medicalHistoryService.findAll());

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(1);

        Page<MedicalHistory> medicalHistoryPage = medicalHistoryService.findAll(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("medicalHistoryPage", medicalHistoryPage);
        int totalPages = medicalHistoryPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        //Devuelve el HTML
        return "medicalHistory/medicalHistory-list";
    }

    @PostMapping("/save")
    public String saveMedicalHistory(@ModelAttribute("medicalHistory") MedicalHistory medicalHistory){

        medicalHistoryService.save(medicalHistory);
        return "redirect:/usuario/historialmedico";
    }
    @GetMapping("/edit/{id}")
    public String showEditMedicalHistoryForm(@PathVariable("id") Integer id, Model model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String userName = userDetails.getUsername();
        User userAut = userService.findByName(userName);

        Optional<MedicalHistory> medicalHistory = medicalHistoryService.findById(id);
        if (medicalHistory.isPresent()){
            if (medicalHistory.get().getUser()==userAut){
                model.addAttribute("medicalHistory", medicalHistory.get());
                List<Illness> illnessList = illnessService.findAll();
                model.addAttribute("allIllness", illnessList);

                return "medicalHistory/medicalHistory-form";
            }else {
                return "error-authoritation";
            }

        }
        else {
            return "medicalHistory/medicalHistory-form-notfound";
        }
    }

    //TODO falta el PostMapping
    //Cuidado solo es un ejemplo, no borramos fisicamente
    @GetMapping("/delete/{id}")
    public String deleteMedicalHistory(@PathVariable("id") Integer id) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String userName = userDetails.getUsername();
        User userAut = userService.findByName(userName);

        Optional<MedicalHistory> medicalHistory = medicalHistoryService.findById(id);
        if (medicalHistory.isPresent()){
            User user=medicalHistory.get().getUser();
            if (userAut==user){
                medicalHistoryService.deleteById(id);
                return "redirect:/usuario/historialmedico";
            }
            else {
                return "error-authentication";
            }}
        return "error";
    }

}
