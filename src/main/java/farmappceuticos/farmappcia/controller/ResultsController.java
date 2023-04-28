package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.Agenda;
import farmappceuticos.farmappcia.model.Results;
import farmappceuticos.farmappcia.services.AgendaService;
import farmappceuticos.farmappcia.services.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping("/resultados")//url
public class ResultsController {
    @Autowired
    private ResultsService service;
    //Para acceder a los métodos

    @GetMapping({"/",""})
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
        results.setFechaHora(LocalDateTime.now());
        service.save(results);
        return "redirect:/resultados/";
    }
    @GetMapping("/edit/{id}")
    public String showEditDataForm(@PathVariable("id") Integer id, Model model) {
        Optional<Results>results=service.findById(id);
        if (results.isPresent()){
            model.addAttribute("datos", results.get());
            return "results/results-form";
        }
        return "error";

    }
    @GetMapping("/delete/{id}")
    public String deleteData(@PathVariable("id") Integer id) {
        service.deleteById(id);
        return "redirect:/resultados/";
    }
}
