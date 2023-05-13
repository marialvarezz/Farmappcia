package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.Illness;
import farmappceuticos.farmappcia.model.Medicine;
import farmappceuticos.farmappcia.services.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/enfermedades")//url
public class IllnessController {
    @Autowired
    private IllnessService illnessService;
    //Para acceder a los métodos

    @GetMapping({"/",""})
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showIllness(Model model,
                              @RequestParam("page")Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size){
        //
        model.addAttribute("illness",illnessService.findAll());

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        Page<Illness> illnessPage = illnessService.findAll(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("illnessPage", illnessPage);
        int totalPages = illnessPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        //Devuelve el HTML
        return "illness/illness-list";
    }



    @GetMapping("/new")
    public String showNewIllnessForm(Model model) {
        model.addAttribute("illness", new Illness());
        return "illness/illness-form";
    }
    @PostMapping("/save")
    public String saveIllness(@ModelAttribute("illness") Illness illness)  {
        illnessService.save(illness);
        return "redirect:/enfermedades/";
    }
    @GetMapping("/edit/{id}")
    public String showEditIllnessForm(@PathVariable("id") Integer id, Model model) {
        Optional<Illness> illness = illnessService.findById(id);
        if (illness.isPresent()){
            model.addAttribute("illness", illness.get());
            return "illness/illness-form";
        }
        else {
            return "illness/illness-form-notfound";
        }
    }

    //TODO falta el PostMapping
    //Cuidado solo es un ejemplo, no borramos fisicamente
    @GetMapping("/delete/{id}")
    public String deleteIllness(@PathVariable("id") Integer id) {
        illnessService.deleteById(id);
        return "redirect:/enfermedades/";
    }

}
