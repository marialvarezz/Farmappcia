package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.Medicine;
import farmappceuticos.farmappcia.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/medicamentos")//url
public class MedicineController {
    @Autowired
    private MedicineService medicineService;
    //Para acceder a los métodos

    @GetMapping("/")
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showMedicines(Model model){
        //
        model.addAttribute("medicine",medicineService.findAll());
        //Devuelve el HTML
        return "medicine/medicine-list";
    }
    @GetMapping("/new")
    public String showNewMedicineForm(Model model) {
        model.addAttribute("medicine", new Medicine());
        return "medicine/medicine-form";
    }
    @PostMapping("/save")
    public String saveMedicine(@ModelAttribute("medicine") Medicine medicine) throws Exception {
        medicineService.save(medicine);
        return "redirect:/medicine/";
    }
    @GetMapping("/edit/{id}")
    public String showEditMedicineForm(@PathVariable("id") Integer id, Model model) {
        Optional<Medicine> medicine = medicineService.findById(id);
        if (medicine.isPresent()){
            model.addAttribute("medicine", medicine.get());
            return "medicine/medicine-form";
        }else{
            return "medicine/medicine-form-notfound";
        }


    }
    @GetMapping("/delete/{id}")
    public String deleteMedicine(@PathVariable("id") Integer id) {
        medicineService.deleteById(id);
        return "redirect:/medicine/";
    }

}
