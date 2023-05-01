package farmappceuticos.farmappcia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests( authorize -> authorize

                //Permitimos todas las visitas a la pagina principal
                .requestMatchers("","/").permitAll()
                //Permitimos todas las visitas a la pagina principal
                .requestMatchers("/registro","/registrarusuario").permitAll()
                //Permitimos la entrada a los css, js e imágenes
                .requestMatchers("/webjars/**","/vendor/**", "/js/**","/css/**","/img/**","/fonts/**","/favicon.ico").permitAll()
                .requestMatchers("*css", "*js").permitAll()
                //Permitimos todas las visitas a /public
                .requestMatchers("/public").permitAll()
                //Solo permitimos a usuarios registrados visitar "/private"
                .requestMatchers("/usuario/**").authenticated() //Permitimos únicamente las visitas de usuarios registrados a  /private
                // Todas las request no filtradas hasta ahora, se rechazarán
                .anyRequest().denyAll()
        );

        http
                .formLogin(form -> form
                        .loginPage("/login").permitAll() //Permitimos todas las visitas a la página de login
                        .loginProcessingUrl("/procesarLogin") // Establece la ruta de procesamiento del formulario de inicio de sesión
                        .defaultSuccessUrl("/usuario")// Establece la ruta de redirección después de que el usuario inicia sesión correctamente
                );

        http.
                logout(logout -> logout
                        // Establece la ruta para procesar la petición de cierre de sesión
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .permitAll()
                );

        return http.build();

    }
}
