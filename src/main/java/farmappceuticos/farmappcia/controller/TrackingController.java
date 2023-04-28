package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.Results;
import farmappceuticos.farmappcia.model.Tracking;
import farmappceuticos.farmappcia.services.ResultsService;
import farmappceuticos.farmappcia.services.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/seguimiento")//url
public class TrackingController {
    @Autowired
    private TrackingService trackingService;
    //Para acceder a los métodos

    @GetMapping({"/",""})
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showData(Model model){
        //
        model.addAttribute("datos",trackingService.findAll());
        //Devuelve el HTML
        return "tracing/tracing-list";
    }
    @GetMapping("/new")
    public String showNewDataForm(Model model) {
        model.addAttribute("datos", new Tracking());
        return "tracing/tracing-form";
    }
    @PostMapping("/save")
    public String saveData(@ModelAttribute("datos") Tracking tracking) {
        trackingService.save(tracking);
        return "redirect:/seguimiento/";
    }
    @GetMapping("/edit/{id}")
    public String showEditDataForm(@PathVariable("id") Integer id, Model model) {
        Optional<Tracking>tracking=trackingService.findById(id);
        if(tracking.isPresent()){
            model.addAttribute("datos", tracking.get());
            return "tracing/tracing-form";
        }
       return "error";
    }
    @GetMapping("/delete/{id}")
    public String deleteData(@PathVariable("id") Integer id) {
        trackingService.deleteById(id);
        return "redirect:/seguimiento/";
    }
}
