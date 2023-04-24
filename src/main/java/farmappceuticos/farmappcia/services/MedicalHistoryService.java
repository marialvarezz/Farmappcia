package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.MedicalHistory;
import farmappceuticos.farmappcia.repositories.MedicalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalHistoryService extends AbstractBusinessServiceSoloEnt <MedicalHistory,Integer, MedicalHistoryRepository> {
    @Autowired
    private MedicalHistoryRepository questionsRepository;

    protected MedicalHistoryService(MedicalHistoryRepository medicalHistoryRepository) {
        super(medicalHistoryRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD
}
