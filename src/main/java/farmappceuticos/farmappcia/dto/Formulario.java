package farmappceuticos.farmappcia.dto;

import farmappceuticos.farmappcia.model.Answers;

import java.util.List;

public class Formulario {
    List<Answers> answers;
    //Constructores

    //getter and setter


    public Formulario(List<Answers> answers) {
        this.answers = answers;
    }

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }

    //Metodo para añadir registros a la lista
    public void añadirRespuestas(Answers answers){
        this.answers.add(answers);
    }

}
