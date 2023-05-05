package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.Illness;
import farmappceuticos.farmappcia.model.IncMedicine;
import farmappceuticos.farmappcia.model.Medicine;
import farmappceuticos.farmappcia.services.IllnessService;
import farmappceuticos.farmappcia.services.IncMedicineService;
import farmappceuticos.farmappcia.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/medicamentosinc")//url
public class IncMedicineController {
    @Autowired
    private IncMedicineService incMedicineService;
    //Para acceder a los métodos

    @Autowired
    private MedicineService medicineService;

    @GetMapping({"/",""})
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showIncMedicine(Model model){
        //
        model.addAttribute("incMedicine",incMedicineService.findAll());
        //Devuelve el HTML
        return "incMedicine/incMedicine-list";
    }
    @GetMapping("/new")
    public String showNewIncMedicineForm(Model model) {
        List<Medicine> medicineList=medicineService.findAll();
        model.addAttribute("allMedicines", medicineList);
        model.addAttribute("incMedicine", new IncMedicine());
        return "incMedicine/incMedicine-form";
    }
    @PostMapping("/save")
    public String saveIncMedicine(@ModelAttribute("incMedicine") IncMedicine incMedicine) {
        incMedicineService.save(incMedicine);
        return "redirect:/medicamentosinc/";
    }
    @GetMapping("/edit/{id}")
    public String showEditIncMedicineForm(@PathVariable("id") Integer id, Model model) {
        Optional<IncMedicine> incMedicine = incMedicineService.findById(id);
        if (incMedicine.isPresent()){
            model.addAttribute("incMedicine", incMedicine.get());
            return "incMedicine/incMedicine-form";
        }
        else {
            return "incMedicine/incMedicine-form-notfound";
        }
    }

    //TODO falta el PostMapping
    //Cuidado solo es un ejemplo, no borramos fisicamente
    @GetMapping("/delete/{id}")
    public String deleteIncMedicine(@PathVariable("id") Integer id) {
        incMedicineService.deleteById(id);
        return "redirect:/medicamentosinc/";
    }



}
