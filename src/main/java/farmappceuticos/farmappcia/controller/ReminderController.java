package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.Reminder;
import farmappceuticos.farmappcia.model.Results;
import farmappceuticos.farmappcia.services.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reminder")//url
public class ReminderController {
    @Autowired
    private ResultsService service;
    //Para acceder a los métodos

    @GetMapping("/")
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showData(Model model){
        //
        model.addAttribute("datos",service.findAll());
        //Devuelve el HTML
        return "reminder/reminder-list";
    }
    @GetMapping("/new")
    public String showNewDataForm(Model model) {
        model.addAttribute("datos", new Reminder());
        return "reminder/reminder-form";
    }
    @PostMapping("/save")
    public String saveData(@ModelAttribute("datos")Reminder reminder) {
        service.save(reminder);
        return "redirect:/reminder/";
    }
    @GetMapping("/edit/{id}")
    public String showEditDataForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("datos", service.findById(id));
        return "reminder/reminder-form";
    }
    @GetMapping("/delete/{id}")
    public String deleteData(@PathVariable("id") Integer id) {
        service.deleteById(id);
        return "redirect:/reminder/";
    }
}
