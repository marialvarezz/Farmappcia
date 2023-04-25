package farmappceuticos.farmappcia.controller;

import farmappceuticos.farmappcia.model.*;
import farmappceuticos.farmappcia.services.AnswersService;
import farmappceuticos.farmappcia.services.QuestionQuestionnaireService;
import farmappceuticos.farmappcia.services.QuestionnaireService;
import farmappceuticos.farmappcia.services.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cuestionariopregunta")//url
public class QuestionQuestionnaireController {

    @Autowired
    private QuestionQuestionnaireService questionQuestionnaireService;

    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private QuestionnaireService questionnaireService;

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
    public String newInvoiceForm(@PathVariable("id")Integer  id, Model model) {
        Optional<Questionnaire> questionnaire = questionnaireService.findById(id);
        if (questionnaire.isPresent()) {
            Questionnaire questionnaire1=questionnaire.get();
            model.addAttribute("questionnaire",questionnaire1);
            for (Questions question:questionnaire1.getQuestions()
                 ) {

                Answers answers=new Answers();



            }
            Answers answers = new Answers();

            answers.setFechaHora(LocalDateTime.now());
            model.addAttribute("answers",answers);
            return "questionnaire/questionnaire-info";
        } else {
            return "error-page";
        }
    }
    @PostMapping("/{id}/respuesta/new")
    public String createInvoice(@PathVariable("id") Integer id, @ModelAttribute("answer") Answers answers) {
        Optional<QuestionQuestionnaire> questionQuestionnaire = questionQuestionnaireService.findById(id);
        if(questionQuestionnaire.isPresent()){
            answers.setQuestionQuestionnaire(questionQuestionnaire.get());
            answers.setFechaHora(LocalDateTime.now());
            answersService.save(answers);
            return "redirect:/cuestionariopregunta/";
        }
        {
            return "error";
        }
    }

    //TODO falta el PostMapping
    //Cuidado solo es un ejmplo, no borramos ficicamente
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        questionQuestionnaireService.deleteById(id);
        return "redirect:/respuesta/";
    }





}
