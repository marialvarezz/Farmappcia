package farmappceuticos.farmappcia.controller;

import farmappceuticos.farmappcia.model.*;
import farmappceuticos.farmappcia.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/cuestionario")//url
public class QuestionnaireController {

    @Autowired
    private QuestionnaireService questionnaireService;
    @Autowired
    private AnswersService answersService;

    @Autowired
    private QuestionsService questionsService;

    @Autowired
    private UserService1 userService;
    @Autowired
    private QuestionQuestionnaireService questionQuestionnaireService;
    //Para acceder a los métodos

    @GetMapping({"/",""})
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showProducts(Model model){
        //
        model.addAttribute("questionnaires",questionnaireService.findAll());
        //Devuelve el HTML
        return "questionnaire/admin-questionnaire-list";
    }
    @GetMapping("/new")
    public String showNewProductForm(Model model) {
        Questionnaire questionnaire=new Questionnaire();
        model.addAttribute("questionnaire", questionnaire);
        List<Questions> questions = questionsService.findAll();
        model.addAttribute("allQuestions", questions);
        model.addAttribute("questionnaire", questionnaire);
        return "questionnaire/questionnaire-form";
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("questionnaire") Questionnaire questionnaire) throws Exception {
        questionnaireService.save(questionnaire);
        return "redirect:/cuestionario/";
    }
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
        Optional<Questionnaire> questionnaire = questionnaireService.findById(id);
        if (questionnaire.isPresent()){
            List<Questions> questions = questionsService.findAll();
            model.addAttribute("allQuestions", questions);
            model.addAttribute("questionnaire", questionnaire.get());
            return "questionnaire/questionnaire-form";
        }
        else {
            return "questionnaire/questionnaire-form-notfound";
        }
    }

    //TODO falta el PostMapping
    //Cuidado solo es un ejmplo, no borramos ficicamente
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        questionnaireService.deleteById(id);
        return "redirect:/cuestionario/";
    }

  






//Cuestionarios



    @GetMapping("/cuestionario/{id}")
    public String verUsuario(@PathVariable("id") Integer id, Model model) {
        Optional<Questionnaire> questionnaire=questionnaireService.findById(id);
        if (questionnaire.isPresent()){
            model.addAttribute("questionnaire", questionnaire.get());
            return "questionnaire/questionnaire-info";
        }
        return "error";
    }


}
