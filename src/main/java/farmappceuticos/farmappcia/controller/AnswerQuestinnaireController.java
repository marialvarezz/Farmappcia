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

    @PostMapping("/usuario/cuestionario/eliminar/{id}")
    public String eliminarrespCuestionario(@PathVariable("id")Integer id,Model model){
        Optional<Questionnaire>questions=questionnaireService.findById(id);
        List<QuestionQuestionnaire> questionnaires=questionQuestionnaireService.findByQuestionnaireToAnswers(questions.get());
        User user=getAut();
        for (QuestionQuestionnaire questionnaire:questionnaires) {
            for (Answers ans:questionnaire.getAnswers()) {
                if (ans.getUser()==user){
                    answersService.deleteById(ans.getId());
                }else {
                    return "redirect:/usuario/cuestionario/";
                }
            }
        }
return "redirect:/usuario/cuestionarios/";
    }

    @PostMapping("/usuario/cuestionario/activar/{id}")
    public String activarCuestionario(@PathVariable("id")Integer id,Model model){
        Optional<Questionnaire>questions=questionnaireService.findById(id);
        List<QuestionQuestionnaire> questionnaires=questionQuestionnaireService.findByQuestionnaireToAnswers(questions.get());

        for (QuestionQuestionnaire questionnaire:questionnaires) {
           User user=getAut();

            if(questionnaire.getAnswers()==null || questionnaire.getAnswers().isEmpty()){
                Answers answers=new Answers();
                answers.setQuestionnaire(questionnaire);
                List<Answers>answersList=new ArrayList<>();
                answersList.add(answers);
                questionnaire.setAnswers(answersList);
                answers.setUser(user);
                questionQuestionnaireService.save(questionnaire);
                answersService.save(answers);
                model.addAttribute("answers",answers);
            } else {


                    Answers answers=new Answers();
                answers.setUser(user);
                for (Answers ans:questionnaire.getAnswers()) {
                  if (ans.getUser()==answers.getUser()){
                      answersService.deleteById(ans.getId());
                  }
                }

                        List<Answers>answersList=questionnaire.getAnswers();

                    questionnaire.setQuestionnaireToAnswers(questionnaire.getQuestionnaireToAnswers());
                    questionnaire.setQuestionsToQuestionnaire(questionnaire.getQuestionsToQuestionnaire());
                    answers.setQuestionnaire(questionnaire);
                questionQuestionnaireService.save(questionnaire);
                    answersList.add(answers);
                    questionnaire.setAnswers(answersList);
                    questionQuestionnaireService.save(questionnaire);
                    answersService.save(answers);
                    model.addAttribute("answers",answers);
                }


            }



        return "redirect:/usuario/responder/" + id;
    }

    @GetMapping("/usuario/responder/{id}")
    public String responderPorId(@PathVariable("id")Integer id,Model model){
        Optional<Questionnaire>questionnaire=questionnaireService.findById(id);
        User user=getAut();
        if (questionnaire.isPresent()) {
            model.addAttribute("questionario",questionnaire.get());
            List<Answers> answersList = new ArrayList<>();
            List<QuestionQuestionnaire> questionnaires = questionQuestionnaireService.findByQuestionnaireToAnswers(questionnaire.get());
            for (QuestionQuestionnaire questionquestionnaire:questionnaires
                 ) {
                for (Answers answer:questionquestionnaire.getAnswers()
                     ) {
                    if (answer.getUser()==getAut()){
                        answersList.add(answer);
                    }

                }



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
            answersService.save(ans);
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
