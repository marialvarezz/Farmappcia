package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.IncMedicine;
import farmappceuticos.farmappcia.repositories.IncMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncMedicineService extends AbstractBusinessServiceSoloEnt <IncMedicine,Integer, IncMedicineRepository> {
    @Autowired
    private IncMedicineRepository questionsRepository;

    protected IncMedicineService(IncMedicineRepository incMedicineRepository) {
        super(incMedicineRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD
}
