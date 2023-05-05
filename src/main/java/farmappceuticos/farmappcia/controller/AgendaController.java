package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.*;
import farmappceuticos.farmappcia.services.AgendaService;
import farmappceuticos.farmappcia.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/agenda")//url
public class AgendaController {
    @Autowired
    private AgendaService agendaService;
    //Para acceder a los métodos
    @Autowired
    private EventService eventService;

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
        Optional<Agenda> agenda = agendaService.findById(id);
        if (agenda.isPresent()){
            model.addAttribute("agenda", agendaService.findById(id));
            return "agenda/agenda-form";
        }else{
            return "agenda/agenda-form-notfound";
        }


    }
    @GetMapping("/delete/{id}")
    public String deleteAgenda(@PathVariable("id") Integer id) {
        agendaService.deleteById(id);
        return "redirect:/agenda/";
    }
    @GetMapping("/info/{id}")
    public String verAgenda(@PathVariable("id") Integer id, Model model) {
        Optional<Agenda> agenda = agendaService.findById(id);
        if (agenda.isPresent()){
            model.addAttribute("agenda", agenda.get());
            return "agenda/agenda-info";
        }
        return "error";
    }

    //Eventos

    @GetMapping("/{id}/eventos/new")
    public String newEventForm(@PathVariable("id") Integer id, Model model){
        Optional<Agenda> agenda = agendaService.findById(id);
        if (agenda.isPresent()){
            Event event = new Event();
            event.setAgendaToEvents(agenda.get());
            model.addAttribute("event", event);
            return "agenda/agenda-event-form";
        }else {
            return "error";
        }
    }

    @PostMapping("/{id}/eventos/new")
    public String createEvento(@PathVariable("id") Integer id,@ModelAttribute("event") Event event){
        Optional<Agenda> agenda = agendaService.findById(id);
        if (agenda.isPresent()){
            event.setAgendaToEvents(agenda.get());
            eventService.save(event);
            return"redirect:/agenda/info/" + id;

        }else {
            return "error";
        }

    }
}
