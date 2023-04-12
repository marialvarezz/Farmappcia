package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.Questions;
import farmappceuticos.farmappcia.services.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("questions",questionsService.findAll());
        //Devuelve el HTML
        return "questions/questions-list";
    }
    @GetMapping("/new")
    public String showNewProductForm(Model model) {
        model.addAttribute("questions", new Questions());
        return "questions/questions-form";
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("questions") Questions questions) {
        questionsService.save(questions);
        return "redirect:/preguntas/";
    }
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("questions", questionsService.findById(id));
        return "questions/questions-form";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        questionsService.deleteById(id);
        return "redirect:/preguntas/";
    }

}
