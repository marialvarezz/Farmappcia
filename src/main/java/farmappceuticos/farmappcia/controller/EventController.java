package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.Agenda;
import farmappceuticos.farmappcia.model.Event;
import farmappceuticos.farmappcia.model.User;
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

import java.util.Optional;

@Controller
@RequestMapping("/evento")//url
public class EventController {
    @Autowired
    private EventService eventService;

    @Autowired
    private UserService1 userService;
    //Para acceder a los métodos

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/")
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showEvents(Model model){
        //
        model.addAttribute("event",eventService.findAll());
        //Devuelve el HTML
        return "event/event-list";
    }

    @PostMapping("/save")
    public String saveEvent(@ModelAttribute("event") Event event) throws Exception {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }

        String userName = userDetails.getUsername();
        User user = userService.findByName(userName);
        Agenda agenda=user.getAgendaToUser();
        event.setDiames(event.getFechahora().getDayOfMonth());
        event.setHora(event.getFechahora().getHour()+" "+event.getFechahora().getMinute());
        System.out.println(event.getHora());
       eventService.crearEvento(event,agenda);

        return "redirect:/usuario/agenda";
    }

    @GetMapping("/edit/{id}")
    public String showEditEventForm(@PathVariable("id") Integer id, Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String userName = userDetails.getUsername();
        User userAut = userService.findByName(userName);
        Optional<Event> event=eventService.findById(id);
        User user= event.get().getAgendaToEvents().getUserToAgenda();
        if (userAut==user){
            if (event.isPresent()){
                model.addAttribute("event", event.get());
                model.addAttribute("user",user);
                return "event/event-form";
            }else{
                return "error";
            }
        }else {
            return "error-authentication";
        }
    }


    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable("id") Integer id) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String userName = userDetails.getUsername();
        User userAut = userService.findByName(userName);
        Optional<Event> event=eventService.findById(id);
        User user= event.get().getAgendaToEvents().getUserToAgenda();
        if(userAut==user){
            eventService.deleteById(id);
            return "redirect:/usuario/agenda";
        }else {
            return "error-authentication";
        }




    }

}
