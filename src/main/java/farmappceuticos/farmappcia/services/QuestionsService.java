package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.Illness;
import farmappceuticos.farmappcia.model.Questions;
import farmappceuticos.farmappcia.model.User;
import farmappceuticos.farmappcia.repositories.QuestionsRepository;
import farmappceuticos.farmappcia.repositories.UserRepository;
import farmappceuticos.farmappcia.utils.IllnessUtils;
import farmappceuticos.farmappcia.utils.QuestionsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionsService extends AbstractBusinessServiceSoloEnt <Questions,Integer,QuestionsRepository> {
    @Autowired
    private QuestionsRepository questionsRepository;

    protected QuestionsService(QuestionsRepository questionsRepository) {
        super(questionsRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD

    final private List<Questions> questions = QuestionsUtils.buildQuestions();
    public Page<Questions> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Questions> list;

        if (questions.size() < startItem){
            list = Collections.emptyList();
        }else {
            int toIndex = Math.min(startItem  + pageSize, questions.size());
            list = questions.subList(startItem, toIndex);
        }
        Page<Questions> questionsPage = new PageImpl<Questions>(list, PageRequest.of(currentPage,pageSize), questions.size());

        return questionsPage;

    }

}
