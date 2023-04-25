package farmappceuticos.farmappcia.services;


import farmappceuticos.farmappcia.model.UserMedicine;
import farmappceuticos.farmappcia.repositories.UserMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMedicineService extends AbstractBusinessServiceSoloEnt<UserMedicine, Integer, UserMedicineRepository>{
    @Autowired
    private UserMedicineRepository userMedicineRepository;

    protected UserMedicineService(UserMedicineRepository userMedicineRepository){
        super(userMedicineRepository);
    }
}
