package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.MedicalHistory;
import farmappceuticos.farmappcia.model.Medicine;
import farmappceuticos.farmappcia.model.Questions;
import farmappceuticos.farmappcia.model.User;
import farmappceuticos.farmappcia.repositories.MedicineRepository;
import farmappceuticos.farmappcia.repositories.QuestionsRepository;
import farmappceuticos.farmappcia.utils.MedicineUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

@Service
public class MedicineService extends AbstractBusinessServiceSoloEnt <Medicine,Integer, MedicineRepository> {
    @Autowired
    private MedicineRepository medicineRepository;

    public Page<Medicine>findByName(String name, Pageable pageable){return medicineRepository.findByName(name,pageable);}
    public Page<Medicine>findByNameAndDescription(String name,String description, Pageable pageable){return medicineRepository.findByNameAndDescription(name,description,pageable);}

    protected MedicineService(MedicineRepository medicineRepository) {
        super(medicineRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD

    final private List<Medicine> medicines = MedicineUtils.buildMedicines();
    public Page<Medicine> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Medicine> list;

        if (medicines.size() < startItem){
            list = Collections.emptyList();
        }else {
            int toIndex = Math.min(startItem  + pageSize, medicines.size());
            list = medicines.subList(startItem, toIndex);
        }
        Page<Medicine> medicinePage = new PageImpl<Medicine>(list, PageRequest.of(currentPage,pageSize), medicines.size());

        return medicinePage;

    }
}
