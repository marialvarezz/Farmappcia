package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.Agenda;
import farmappceuticos.farmappcia.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/agenda")//url
public class AgendaController {
    @Autowired
    private AgendaService agendaService;
    //Para acceder a los métodos

    @GetMapping("/")
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showAgendas(Model model){
        //
        model.addAttribute("agenda",agendaService.findAll());
        //Devuelve el HTML
        return "agenda/agenda-list";
    }
    @GetMapping("/new")
    public String showNewAgendaForm(Model model) {
        model.addAttribute("agenda", new Agenda());
        return "agenda/agenda-form";
    }
    @PostMapping("/save")
    public String saveAgenda(@ModelAttribute("agenda") Agenda agenda) {
        agendaService.save(agenda);
        return "redirect:/agenda/";
    }
    @GetMapping("/edit/{id}")
    public String showEditAgendaForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("agenda", agendaService.findById(id));
        return "agenda/agenda-form";
    }
    @GetMapping("/delete/{id}")
    public String deleteAgenda(@PathVariable("id") Integer id) {
        agendaService.deleteById(id);
        return "redirect:/agenda/";
    }

}
