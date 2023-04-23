package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.Questions;
import farmappceuticos.farmappcia.model.UserMedicineInc;
import farmappceuticos.farmappcia.repositories.QuestionsRepository;
import farmappceuticos.farmappcia.repositories.UserMedicineIncRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMedicineIncService extends AbstractBusinessServiceSoloEnt <UserMedicineInc,Integer, UserMedicineIncRepository> {
    @Autowired
    private QuestionsRepository questionsRepository;

    protected UserMedicineIncService(UserMedicineIncRepository userMedicineIncRepository) {
        super(userMedicineIncRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD
}
