package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.UserData;
import farmappceuticos.farmappcia.repositories.UserDataRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDataService extends AbstractBusinessServiceSoloEnt <UserData,Integer, UserDataRepository> {

    protected UserDataService(UserDataRepository userDataRepositoryRepository) {
        super(userDataRepositoryRepository);
    }
}
