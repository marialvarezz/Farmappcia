package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.Illness;
import farmappceuticos.farmappcia.model.Medicine;
import farmappceuticos.farmappcia.model.Questions;
import farmappceuticos.farmappcia.repositories.IllnessRepository;
import farmappceuticos.farmappcia.repositories.QuestionsRepository;
import farmappceuticos.farmappcia.utils.IllnessUtils;
import farmappceuticos.farmappcia.utils.MedicineUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class IllnessService extends AbstractBusinessServiceSoloEnt <Illness,Integer, IllnessRepository> {
    @Autowired
    private IllnessRepository questionsRepository;

    protected IllnessService(IllnessRepository illnessRepository) {
        super(illnessRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD

    final private List<Illness> illnesses = IllnessUtils.buildIllnesses();
    public Page<Illness> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Illness> list;

        if (illnesses.size() < startItem){
            list = Collections.emptyList();
        }else {
            int toIndex = Math.min(startItem  + pageSize, illnesses.size());
            list = illnesses.subList(startItem, toIndex);
        }
        Page<Illness> illnessPage = new PageImpl<Illness>(list, PageRequest.of(currentPage,pageSize), illnesses.size());

        return illnessPage;

    }

}
