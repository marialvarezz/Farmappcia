package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.User;
import farmappceuticos.farmappcia.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //Implementación de los métodos principales que se usan al entrar en el CRUD
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }
    public Optional<User> findByName(String username){
        return userRepository.findByUsername(username);
    }
    public User save(User user) {
        return userRepository.save(user);
    }
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
