package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.MedicalHistory;
import farmappceuticos.farmappcia.model.Medicine;
import farmappceuticos.farmappcia.model.User;
import farmappceuticos.farmappcia.repositories.MedicalHistoryRepository;
import farmappceuticos.farmappcia.utils.MedicalHistoryUtils;
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
public class MedicalHistoryService extends AbstractBusinessServiceSoloEnt <MedicalHistory,Integer, MedicalHistoryRepository> {
    @Autowired
    private MedicalHistoryRepository questionsRepository;

    public Page<MedicalHistory>findByUser(User user, Pageable pageable){return questionsRepository.findByUser(user,pageable);}
    protected MedicalHistoryService(MedicalHistoryRepository medicalHistoryRepository) {
        super(medicalHistoryRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD

    final private List<MedicalHistory> medicalHistories = MedicalHistoryUtils.buildMedicalHistories();
    public Page<MedicalHistory> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<MedicalHistory> list;

        if (medicalHistories.size() < startItem){
            list = Collections.emptyList();
        }else {
            int toIndex = Math.min(startItem  + pageSize, medicalHistories.size());
            list = medicalHistories.subList(startItem, toIndex);
        }
        Page<MedicalHistory> medicalHistoryPage = new PageImpl<MedicalHistory>(list, PageRequest.of(currentPage,pageSize), medicalHistories.size());

        return medicalHistoryPage;

    }


}
