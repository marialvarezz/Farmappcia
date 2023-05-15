package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.Medicine;
import farmappceuticos.farmappcia.repositories.MedicineRepository;
import farmappceuticos.farmappcia.services.MedicineService;
import farmappceuticos.farmappcia.util.SearchFromData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/medicamentos")//url
public class MedicineController {
    @Autowired
    private MedicineService medicineService;
    @Autowired
    private MedicineRepository medicineRepository;
    //Para acceder a los métodos

    @GetMapping({"/",""})
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showMedicines(Model model,
                                @RequestParam("page")Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size){
        //
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
        return "medicine/medicine-list";
    }


    @PostMapping({"/",""})
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String filtrado(Model model,@ModelAttribute("searchFormData") SearchFromData searchFromData,
                                @RequestParam("page")Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size){
        //
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
        //Devuelve el HTML
        return "medicine/medicine-list";
    }


    @GetMapping("/new")
    public String showNewMedicineForm(Model model) {
        model.addAttribute("medicine", new Medicine());
        return "medicine/medicine-form";
    }
    @PostMapping("/save")

    public String saveMedicine(@ModelAttribute("medicine") Medicine medicine){

        medicineService.save(medicine);
        return "redirect:/medicamentos/";
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
        return "redirect:/medicamentos/";
    }

}
