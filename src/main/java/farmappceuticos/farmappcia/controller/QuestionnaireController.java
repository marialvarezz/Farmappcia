package farmappceuticos.farmappcia.controller;

import farmappceuticos.farmappcia.model.*;
import farmappceuticos.farmappcia.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private QuestionQuestionnaireService questionQuestionnaireService;
    //Para acceder a los métodos

    @GetMapping({"/",""})
    //Model es el objeto que utiliza Spring para pasar al html los datos de la BD
    public String showProducts(Model model){
        //
        model.addAttribute("questionnaires",questionnaireService.findAll());
        //Devuelve el HTML
        return "questionnaire/questionnaire-list";
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
@GetMapping("/{id}/respuestas")
public String showAnswerQuestionnaireForm(@PathVariable("id") Integer id, Model model) {
    Optional<Questionnaire> questionnaire = questionnaireService.findById(id);
    if (questionnaire.isPresent()){
        Questionnaire questionnaire1=questionnaire.get();
        List<Questions>questions=questionnaire1.getQuestions();
        //List<Answers>answersList=new ArrayList<>();
        //List<QuestionQuestionnaire>questionQuestionnaireList=new ArrayList<>();
        model.addAttribute("questionnaire", questionnaire1);
        for (Questions question:questions
             ) {
            QuestionQuestionnaire questionQuestionnaire=new QuestionQuestionnaire();
            Answers answer=new Answers();

            questionQuestionnaire.setQuestionnaire(questionnaire1);
            questionQuestionnaire.setQuestion(question);
            questionQuestionnaire.setAnswer(answer);

            answer.setQuestionQuestionnaire(questionQuestionnaire);
            model.addAttribute("answers",answer);
            model.addAttribute("questionnaireQuestion",questionQuestionnaire);
           // questionQuestionnaireList.add(questionQuestionnaire);
            //answersList.add(answer);
        }
        return "questionnaire/questionnaire-info";
    }
    else {
        return "questionnaire/questionnaire-form-notfound";
    }
}
    @PostMapping("/{id}/respuestas")
    public String showAnswerQuestionnaireFormPost(@PathVariable("id") Integer id,@ModelAttribute("answers") Answers answers) {
       Optional<Questionnaire>questionnaire=questionnaireService.findById(id);

       if (questionnaire.isPresent()){
           List<Answers> answersList=new ArrayList<>();
           List<QuestionQuestionnaire>questionQuestionnaireList=new ArrayList<>();
           Questionnaire questionnaire1=questionnaire.get();
           for (Questions question:questionnaire1.getQuestions()) {
               QuestionQuestionnaire questionQuestionnaire=new QuestionQuestionnaire();
               questionQuestionnaire.setAnswer(answers);
               questionQuestionnaire.setQuestionnaire(questionnaire1);
               questionQuestionnaire.setQuestion(question);
               answers.setFechaHora(LocalDateTime.now());
               answers.setQuestionQuestionnaire(questionQuestionnaire);
               answersList.add(answers);
               questionQuestionnaireList.add(questionQuestionnaire);
           }
           for (Answers answer:answersList
                ) {answersService.save(answer);
           }
           for (QuestionQuestionnaire questionQuestionnaire:questionQuestionnaireList
                ) {questionQuestionnaireService.save(questionQuestionnaire);

           }
          // questionQuestionnaireService.save(questionQuestionnaireList);
          // answersService.save(answersList);
           return "redirect:/respuesta/";
       }
       return "error";
    }

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
