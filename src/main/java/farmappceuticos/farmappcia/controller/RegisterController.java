package farmappceuticos.farmappcia.controller;

import farmappceuticos.farmappcia.dto.UserDto;
import farmappceuticos.farmappcia.model.User;
import farmappceuticos.farmappcia.repositories.UserRepository;
import farmappceuticos.farmappcia.services.UserService1;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
public class RegisterController {

    @Autowired
    private UserService1 userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registro")
    public String mostrarFormularioDeRegistro(Model model)
    {
        UserDto userDto = new UserDto();

        model.addAttribute("user",userDto);
        return "adminUser/register-user-form";
    }

    @PostMapping("/registrarusuario")
    public String registarUsuario(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model)
    {
        User user = userRepository.findByUsername(userDto.getUsername());
        if(user != null && user.getUsername() != null && !user.getUsername().isEmpty()){
            result.rejectValue("username", null,
                    "Usuario ocupado, por favor introduzca otro usuario");
        }
        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "adminUser/register-user-form";
        }

        userService.guardarUsuarioDTO(userDto);

        return "redirect:/";
    }

}
