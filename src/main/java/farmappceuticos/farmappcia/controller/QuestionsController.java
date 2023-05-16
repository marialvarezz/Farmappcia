package farmappceuticos.farmappcia.controller;
import farmappceuticos.farmappcia.model.Illness;
import farmappceuticos.farmappcia.model.Questionnaire;
import farmappceuticos.farmappcia.model.Questions;
import farmappceuticos.farmappcia.services.QuestionnaireService;
import farmappceuticos.farmappcia.services.QuestionsService;
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
@RequestMapping("/preguntas")//url
public class QuestionsController {
    @Autowired
    private QuestionsService questionsService;
    //Para acceder a los métodos

    @GetMapping({"/",""})
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showProducts(Model model,
                               @RequestParam("page")Optional<Integer> page,
                               @RequestParam("size") Optional<Integer> size){
        //
        model.addAttribute("questions",questionsService.findAll());

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        Page<Questions> questionsPage = questionsService.findAll(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("questionsPage", questionsPage);
        int totalPages = questionsPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        //Devuelve el HTML
        return "questions/questions-list";
    }

    @GetMapping("/new")
    public String showNewProductForm(Model model) {
        model.addAttribute("question", new Questions());
        return "questions/questions-form";
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("question") Questions questions) throws Exception {
        questionsService.save(questions);
        return "redirect:/preguntas/";
    }
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
        Optional<Questions> questions = questionsService.findById(id);
        if (questions.isPresent()){
            model.addAttribute("question", questions.get());
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
        questionsService.deleteById(id);
        return "redirect:/preguntas/";
    }

}
