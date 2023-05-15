package farmappceuticos.farmappcia.controller;

import farmappceuticos.farmappcia.dto.Formulario;
import farmappceuticos.farmappcia.model.*;
import farmappceuticos.farmappcia.services.AnswersService;
import farmappceuticos.farmappcia.services.QuestionQuestionnaireService;
import farmappceuticos.farmappcia.services.QuestionnaireService;
import farmappceuticos.farmappcia.services.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AnswerQuestinnaireController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    private QuestionQuestionnaireService questionQuestionnaireService;
    @Autowired
    private AnswersService answersService;

    @Autowired
    UserService1 userService;

    @PostMapping("/usuario/cuestionario/activar/{id}")
    public String activarCuestionario(@PathVariable("id")Integer id,Model model){
        Optional<Questionnaire>questions=questionnaireService.findById(id);
        List<QuestionQuestionnaire> questionnaires=questionQuestionnaireService.findByQuestionnaireToAnswers(questions.get());

        for (QuestionQuestionnaire questionnaire:questionnaires) {
           User user=getAut();

            if(questionnaire.getAnswers()==null){
                Answers answers=new Answers();
                answers.setQuestionnaire(questionnaire);
                questionnaire.setAnswers(answers);
                answers.setUser(user);
                answersService.save(answers);
                model.addAttribute("answers",answers);
            } else if (questionnaire.getAnswers().getUser()!=user) {
                Answers answers=new Answers();
                QuestionQuestionnaire ques=new QuestionQuestionnaire();
                ques.setAnswers(answers);
                ques.setQuestionnaireToAnswers(questionnaire.getQuestionnaireToAnswers());
                ques.setQuestionsToQuestionnaire(questionnaire.getQuestionsToQuestionnaire());
                answers.setQuestionnaire(ques);
                answers.setUser(user);
                answersService.save(answers);
                model.addAttribute("answers",answers);
            }else if (questionnaire.getAnswers().getRespuesta()==null){

            }
            else {
                return "error";
            }
        }

        return "redirect:/usuario/responder/" + id;
    }

    @GetMapping("/usuario/responder/{id}")
    public String responderPorId(@PathVariable("id")Integer id,Model model){
        Optional<Questionnaire>questionnaire=questionnaireService.findById(id);
        if (questionnaire.isPresent()) {
            model.addAttribute("questionario",questionnaire.get());
            List<Answers> answersList = new ArrayList<>();
            List<QuestionQuestionnaire> questionnaires = questionQuestionnaireService.findByQuestionnaireToAnswers(questionnaire.get());
            for (QuestionQuestionnaire questionquestionnaire:questionnaires
                 ) {
            Answers answer=questionquestionnaire.getAnswers();
                answersList.add(answer);

            }
            Formulario formulario=new Formulario(answersList);
            model.addAttribute("formulario",formulario);
            return "/answers/answer-question";
        }
        return "error";
    }

    @PostMapping("/usuario/responder/")
    public String SaveresponderPorId(@ModelAttribute("formulario") Formulario formulario) throws Exception {
            List<Answers>answersList=formulario.getAnswers();
        for (Answers ans:answersList
             ) {
            ans.setFechaHora(LocalDateTime.now());

        }
            answersService.save(formulario.getAnswers());
            return "redirect:/usuario/";

    }

    public User getAut(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String userName = userDetails.getUsername();
        User user = userService.findByName(userName);
        return user;
    }
}
