package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.Questions;
import farmappceuticos.farmappcia.services.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/preguntas")//url
public class QuestionsController {
    @Autowired
    private QuestionsService questionsService;
    //Para acceder a los métodos

    @GetMapping("/")
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showProducts(Model model){
        //
        model.addAttribute("questions",questionsService.buscarEntidades());
        //Devuelve el HTML
        return "questions/questions-list";
    }
    @GetMapping("/new")
    public String showNewProductForm(Model model) {
        model.addAttribute("questions", new Questions());
        return "questions/questions-form";
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("questions") Questions questions) throws Exception {
        questionsService.guardar(questions);
        return "redirect:/preguntas/";
    }
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
        Optional<Questions> questions = questionsService.encuentraPorId(id);
        if (questions.isPresent()){
            model.addAttribute("questions", questions.get());
            return "questions/questions-form";
        }
        else {
            return "questions/questions-form-notfound";
        }
    }

    //TODO falta el PostMapping
    //Cuidado solo es un ejmplo, no borramos ficicamente
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        questionsService.eliminarPorId(id);
        return "redirect:/preguntas/";
    }

}
