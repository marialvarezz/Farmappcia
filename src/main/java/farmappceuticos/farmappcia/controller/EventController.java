package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.Event;
import farmappceuticos.farmappcia.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/eventos")//url
public class EventController {
    @Autowired
    private EventService eventService;
    //Para acceder a los métodos

    @GetMapping("/")
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showEvents(Model model){
        //
        model.addAttribute("event",eventService.buscarEntidades());
        //Devuelve el HTML
        return "event/event-list";
    }
    @GetMapping("/new")
    public String showNewEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "event/event-form";
    }
    @PostMapping("/save")
    public String saveEvent(@ModelAttribute("event") Event event) throws Exception {
        eventService.guardar(event);
        return "redirect:/event/";
    }
    @GetMapping("/edit/{id}")
    public String showEditEventForm(@PathVariable("id") Integer id, Model model) {
        Optional<Event> event = eventService.encuentraPorId(id);
        if (event.isPresent()){
            model.addAttribute("event", event.get());
            return "event/event-form";
        }else{
            return "event/event-form-notfound";
        }


    }
    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable("id") Integer id) {
        eventService.eliminarPorId(id);
        return "redirect:/event/";
    }

}
