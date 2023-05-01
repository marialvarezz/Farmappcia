package farmappceuticos.farmappcia.services;

import farmappceuticos.farmappcia.model.Role;
import farmappceuticos.farmappcia.model.User;
import farmappceuticos.farmappcia.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.List;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user != null )
        {
            //Es un User de la clase principal de SpringSecurity (UserDetails-User)
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    mapRolesToAuthorities(user.getRoles())
            );
        }
        else
        {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        // Utilizar streams de Java para mapear cada rol a una instancia de SimpleGrantedAuthority
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .toList(); // Convertir el stream en una lista
    }
}
