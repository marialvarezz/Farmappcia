package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.Reminder;
import farmappceuticos.farmappcia.model.Results;
import farmappceuticos.farmappcia.services.ReminderService;
import farmappceuticos.farmappcia.services.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
@RequestMapping("/recordatorios")//url
public class ReminderController {
    @Autowired
    private ReminderService reminderService;
    //Para acceder a los métodos

    @GetMapping("/")
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showData(Model model){
        //
        model.addAttribute("datos",reminderService.findAll());
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
        reminderService.save(reminder);
        return "redirect:/recordatorios/";
    }
    @GetMapping("/edit/{id}")
    public String showEditDataForm(@PathVariable("id") Integer id, Model model) {
        Optional<Reminder> reminder=reminderService.findById(id);
        if(reminder.isPresent()){
            model.addAttribute("datos", reminder.get());
            return "reminder/reminder-form";
        }
        return "error";
    }
    @GetMapping("/delete/{id}")
    public String deleteData(@PathVariable("id") Integer id) {
        reminderService.deleteById(id);
        return "redirect:/recordatorios/";
    }
}
