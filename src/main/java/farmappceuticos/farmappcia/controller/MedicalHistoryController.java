package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.MedicalHistory;
import farmappceuticos.farmappcia.services.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/historialMedico")//url
public class MedicalHistoryController {
    @Autowired
    private MedicalHistoryService medicalHistoryService;
    //Para acceder a los métodos

    @GetMapping({"/",""})
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showMedicalHistory(Model model){
        //
        model.addAttribute("medicalHistory",medicalHistoryService.findAll());
        //Devuelve el HTML
        return "medicalHistory/medicalHistory-list";
    }
    @GetMapping("/new")
    public String showNewMedicalHistoryForm(Model model) {
        model.addAttribute("medicalHistory", new MedicalHistory());
        return "medicalHistory/medicalHistory-form";
    }
    @PostMapping("/save")
    public String saveMedicalHistory(@ModelAttribute("medicalHistory") MedicalHistory medicalHistory){
        medicalHistoryService.save(medicalHistory);
        return "redirect:/historialMedico/";
    }
    @GetMapping("/edit/{id}")
    public String showEditMedicalHistoryForm(@PathVariable("id") Integer id, Model model) {
        Optional<MedicalHistory> medicalHistory = medicalHistoryService.findById(id);
        if (medicalHistory.isPresent()){
            model.addAttribute("medicalHistory", medicalHistory.get());
            return "medicalHistory/medicalHistory-form";
        }
        else {
            return "medicalHistory/medicalHistory-form-notfound";
        }
    }

    //TODO falta el PostMapping
    //Cuidado solo es un ejemplo, no borramos fisicamente
    @GetMapping("/delete/{id}")
    public String deleteMedicalHistory(@PathVariable("id") Integer id) {
        medicalHistoryService.deleteById(id);
        return "redirect:/historialMedico/";
    }

}
