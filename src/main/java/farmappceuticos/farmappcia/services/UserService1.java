package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.dto.UserDto;
import farmappceuticos.farmappcia.model.User;
import farmappceuticos.farmappcia.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Service
public class UserService1 extends AbstractBusinessServiceSoloEnt <User,Integer, UserRepository> {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;



    public UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        String[] str = user.getName().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        userDto.setBirthDate(user.getBirthDate());
        return userDto;
    }

    public User guardarUsuarioDTO (UserDto userDto)
    {
        User user = new User();
        user.setName(userDto.getFirstName() + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setBirthDate(userDto.getBirthDate());
        user.setRegistrationDateTime(LocalDateTime.now());
        return userRepository.save(user);
    }





    protected UserService1(UserRepository userRepository) {
        super(userRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD

    public User findByName(String username){
        return userRepository.findByUsername(username);
    }
}
