package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.User;
import farmappceuticos.farmappcia.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService1 extends AbstractBusinessServiceSoloEnt <User,Integer, UserRepository> {
    @Autowired
    private UserRepository userRepository;







    protected UserService1(UserRepository userRepository) {
        super(userRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD

    public User findByName(String username){
        return userRepository.findByUsername(username);
    }
}
