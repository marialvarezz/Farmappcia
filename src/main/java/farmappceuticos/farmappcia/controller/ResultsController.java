package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.Agenda;
import farmappceuticos.farmappcia.model.Results;
import farmappceuticos.farmappcia.services.AgendaService;
import farmappceuticos.farmappcia.services.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/results")//url
public class ResultsController {
    @Autowired
    private ResultsService service;
    //Para acceder a los métodos

    @GetMapping("/")
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showData(Model model){
        //
        model.addAttribute("datos",service.findAll());
        //Devuelve el HTML
        return "results/results-list";
    }
    @GetMapping("/new")
    public String showNewDataForm(Model model) {
        model.addAttribute("datos", new Results());
        return "results/results-form";
    }
    @PostMapping("/save")
    public String saveData(@ModelAttribute("datos") Results results) {
        service.save(results);
        return "redirect:/results/";
    }
    @GetMapping("/edit/{id}")
    public String showEditDataForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("datos", service.findById(id));
        return "results/results-form";
    }
    @GetMapping("/delete/{id}")
    public String deleteData(@PathVariable("id") Integer id) {
        service.deleteById(id);
        return "redirect:/results/";
    }
}
