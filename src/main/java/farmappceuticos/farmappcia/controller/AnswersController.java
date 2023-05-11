package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.Answers;

import farmappceuticos.farmappcia.services.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/respuesta")//url
public class AnswersController {
    @Autowired
    private AnswersService answersService;
    //Para acceder a los métodos

    @GetMapping({"/",""})
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showProducts(Model model){
        //
        model.addAttribute("answers",answersService.findAll());
        //Devuelve el HTML
        return "answers/answers-list";
    }
    @GetMapping("/new")
    public String showNewProductForm(Model model) {
        Answers answer=new Answers();
        answer.setFechaHora(LocalDateTime.now());
        model.addAttribute("answers",answer);
        return "answers/answers-form";
    }
    @PostMapping("/save")
    public String saveAnswer(@ModelAttribute("answers") Answers answers) {
        answersService.save(answers);
        return "redirect:/cuestionariopregunta/";
    }
    @GetMapping("/edit/{id}")
    public String showEditAnswerForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("answers", answersService.findById(id));
        return "answers/answers-form";
    }
    @GetMapping("/delete/{id}")
    public String deleteAnswer(@PathVariable("id") Integer id) {
        answersService.deleteById(id);
        return "redirect:/respuesta/";
    }

}
