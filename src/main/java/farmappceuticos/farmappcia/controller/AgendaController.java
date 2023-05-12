package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.*;
import farmappceuticos.farmappcia.services.AgendaService;
import farmappceuticos.farmappcia.services.EventService;
import farmappceuticos.farmappcia.services.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @Autowired
    UserService1 userService;


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/")
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showAgendas(Model model){
        //
        model.addAttribute("agenda",agendaService.findAll());
        //Devuelve el HTML
        return "agenda/agenda-list";
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
    @GetMapping("/eventos/new")
    public String newEventForm( Model model){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String userName = userDetails.getUsername();
        User user = userService.findByName(userName);
        Agenda agenda = user.getAgendaToUser();

            Event event = new Event();
            event.setAgendaToEvents(agenda);
            model.addAttribute("user",user);
            model.addAttribute("event", event);
            return "agenda/agenda-event-form";

    }



    @PostMapping("/eventos/new")
    public String createEvento(@ModelAttribute("event") Event event){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String userName = userDetails.getUsername();
        User user = userService.findByName(userName);
        Agenda agenda = user.getAgendaToUser();
        event.setDiames(event.getFechahora().getDayOfMonth());

        event.setHora(event.getFechahora().getHour()+":"+event.getFechahora().getMinute());
            event.setAgendaToEvents(agenda);
            eventService.crearEvento(event,agenda);

            return"redirect:/usuario/agenda" ;


    }
}
