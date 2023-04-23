package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.Medicine;
import farmappceuticos.farmappcia.model.Questions;
import farmappceuticos.farmappcia.repositories.MedicineRepository;
import farmappceuticos.farmappcia.repositories.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService extends AbstractBusinessServiceSoloEnt <Medicine,Integer, MedicineRepository> {
    @Autowired
    private MedicineRepository medicineRepository;

    protected MedicineService(MedicineRepository medicineRepository) {
        super(medicineRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD
}
