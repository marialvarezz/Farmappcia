package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.dto.UserDto;
import farmappceuticos.farmappcia.model.Medicine;
import farmappceuticos.farmappcia.model.Role;
import farmappceuticos.farmappcia.model.User;
import farmappceuticos.farmappcia.repositories.RoleRepository;
import farmappceuticos.farmappcia.repositories.UserRepository;
import farmappceuticos.farmappcia.utils.MedicineUtils;
import farmappceuticos.farmappcia.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;

import java.util.List;
import java.util.Optional;


@Service
public class UserService1 extends AbstractBusinessServiceSoloEnt <User,Integer, UserRepository> {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${default.user.role}") // (from application.properties
    private String defaultUserRole;



    public UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        String[] str = user.getName().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        userDto.setBirthDate(user.getBirthDate());
        return userDto;
    }

    public User guardarUsuarioDTO (UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " +userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setBirthDate(userDto.getBirthDate());
        user.setRegistrationDateTime(LocalDateTime.now());
        Role role = roleRepository.findByName(defaultUserRole);
        if(role == null){
            role = addRoleIfNotExists();
        }
        user.setRoles(Arrays.asList(role));
        return userRepository.save(user);
    }

    public User guardarUs(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role rol = roleRepository.findByName(defaultUserRole);

        if(rol == null){
            rol = addRoleIfNotExists();
        }
        user.setRoles(List.of(rol));
        return userRepository.save(user);
    }



    private Role addRoleIfNotExists(){
        Role role = new Role();
        role.setName(defaultUserRole);
        return roleRepository.save(role);
    }

    public Optional<User>findByEmail(String email){ return userRepository.findByEmail(email);}

    public List<User> findByTutorMail(String tutorMail){ return userRepository.findByTutorMail(tutorMail);}




    protected UserService1(UserRepository userRepository) {
        super(userRepository);
    }
    //Implementación de los métodos principales que se usan al entrar en el CRUD

    public User findByName(String username){
        return userRepository.findByUsername(username);
    }

    final private List<User> userList = UserUtils.buildUsers();
    public Page<User> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<User> list;

        if (userList.size() < startItem){
            list = Collections.emptyList();
        }else {
            int toIndex = Math.min(startItem  + pageSize, userList.size());
            list = userList.subList(startItem, toIndex);
        }
        Page<User> userPage = new PageImpl<User>(list, PageRequest.of(currentPage,pageSize), userList.size());

        return userPage;

    }



}
