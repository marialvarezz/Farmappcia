package farmappceuticos.farmappcia.controller;

import farmappceuticos.farmappcia.model.Answers;
import farmappceuticos.farmappcia.model.QuestionQuestionnaire;
import farmappceuticos.farmappcia.model.Questions;
import farmappceuticos.farmappcia.services.AnswersService;
import farmappceuticos.farmappcia.services.QuestionQuestionnaireService;
import farmappceuticos.farmappcia.services.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping("/cuestionariopregunta")//url
public class QuestionQuestionnaireController {

    @Autowired
    private QuestionQuestionnaireService questionQuestionnaireService;

    @Autowired
    private QuestionsService questionsService;

    @Autowired
    private
    AnswersService answersService;
    //Para acceder a los métodos


    @GetMapping({"/",""})
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showProducts(Model model){
        //
        model.addAttribute("questionQuestionnaire",questionQuestionnaireService.findAll());


        //Devuelve el HTML
        return "questionQuestionnaire/questionQuestionnaire-list";
    }


    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("questionnaire") QuestionQuestionnaire questionQuestionnaire) throws Exception {
        questionQuestionnaireService.save(questionQuestionnaire);
        return "redirect:/cuestionario/";
    }
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
        Optional<QuestionQuestionnaire> questionQuestionnaire = questionQuestionnaireService.findById(id);
        if (questionQuestionnaire.isPresent()){
            model.addAttribute("questionQuestionnaire", questionQuestionnaire.get());
            return "questionnaire/questionnaire-form";
        }
        else {
            return "questionnaire/questionnaire-form-notfound";
        }
    }

    @GetMapping("/{id}/respuesta/new")
    public String newInvoiceForm(@PathVariable("id") Integer id, Model model) {
        Optional<QuestionQuestionnaire> questionQuestionnaire = questionQuestionnaireService.findById(id);
        if (questionQuestionnaire.isPresent()) {
            Answers answers = new Answers();
            answers.setQuestionnaire(questionQuestionnaire.get());
            answers.setFechaHora(LocalDateTime.now());
            model.addAttribute("answers",answers);
            return "answers/answers-form";
        } else {
            return "error-page";
        }
    }
    @PostMapping("/{id}/respuesta/new")
    public String createInvoice(@PathVariable("id") Integer id, @ModelAttribute("answer") Answers answers) {
        Optional<QuestionQuestionnaire> questionQuestionnaire = questionQuestionnaireService.findById(id);
        if(questionQuestionnaire.isPresent()){
            answers.setQuestionnaire(questionQuestionnaire.get());
            answers.setFechaHora(LocalDateTime.now());
            answersService.save(answers);
            return "redirect:/cuestionariopregunta/";
        }
        {
            return "error";
        }
    }

    //Cuidado solo es un ejmplo, no borramos ficicamente
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        questionQuestionnaireService.deleteById(id);
        return "redirect:/respuesta/";
    }








}
