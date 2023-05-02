package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.Illness;
import farmappceuticos.farmappcia.model.MedicalHistory;
import farmappceuticos.farmappcia.services.IllnessService;
import farmappceuticos.farmappcia.services.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/historialmedico")//url
public class MedicalHistoryController {
    @Autowired
    private MedicalHistoryService medicalHistoryService;

    @Autowired
    private IllnessService illnessService;
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
        List<Illness> illnessList = illnessService.findAll();
        model.addAttribute("allIllness", illnessList);
        return "medicalHistory/medicalHistory-form";
    }
    @PostMapping("/save")
    public String saveMedicalHistory(@ModelAttribute("medicalHistory") MedicalHistory medicalHistory){
        Integer id=medicalHistory.getUser().getId();
        medicalHistoryService.save(medicalHistory);
        return "redirect:/usuario/info/"+id;
    }
    @GetMapping("/edit/{id}")
    public String showEditMedicalHistoryForm(@PathVariable("id") Integer id, Model model) {
        Optional<MedicalHistory> medicalHistory = medicalHistoryService.findById(id);
        if (medicalHistory.isPresent()){
            model.addAttribute("medicalHistory", medicalHistory.get());
            List<Illness> illnessList = illnessService.findAll();
            model.addAttribute("allIllness", illnessList);

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
        Integer y=medicalHistoryService.findById(id).get().getUser().getId();
        medicalHistoryService.deleteById(id);
        return "redirect:/usuario/info/"+y;
    }

}
