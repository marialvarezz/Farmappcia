package farmappceuticos.farmappcia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QuestionQuestionnaireId implements Serializable {
     // indica que esta clase se puede embeber en otra entidad

        @Column(name = "questionId") // indica el nombre de la columna en la tabla que almacena el ID de la factura
        private Integer questionId;


        @Column(name = "questionnaireId") // indica el nombre de la columna en la tabla que almacena el ID del impuesto
        private Integer questionnaireId;


    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionQuestionnaireId that = (QuestionQuestionnaireId) o;
        return Objects.equals(questionId, that.questionId) && Objects.equals(questionnaireId, that.questionnaireId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, questionnaireId);
    }
}