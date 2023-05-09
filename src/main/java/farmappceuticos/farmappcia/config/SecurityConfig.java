package farmappceuticos.farmappcia.config;

import farmappceuticos.farmappcia.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests( authorize -> authorize
                //Permitimos la entrada a los css, js e imágenes
                .requestMatchers("/webjars/**","/vendor/**", "/js/**","/css/**","/img/**","/fonts/**","/favicon.ico").permitAll()
                .requestMatchers("*css", "*js").permitAll()
                //Permitimos todas las visitas a la pagina principal
                .requestMatchers("","/","/medicamentos/").permitAll()
                //Permitimos todas las visitas a la pagina principal
                .requestMatchers("/registro","/registrarusuario").permitAll()
                //Permitimos todas las visitas a /public
                .requestMatchers("/public").permitAll()
                //Solo permitimos a usuarios registrados visitar "/private"
                .requestMatchers("/usuario/**").authenticated() //Permitimos únicamente las visitas de usuarios registrados a  /private
                // Todas las request no filtradas hasta ahora, se rechazarán
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().hasRole("ADMIN")
        );

        http
                .formLogin(form -> form
                        .loginPage("/login") //Establecemos la url del controlador para login
                        .loginProcessingUrl("/procesarLogin") // Establece la ruta de procesamiento del formulario de inicio de sesión
                        //.failureUrl("/login-error")
                        .defaultSuccessUrl("/usuario")// Establece la ruta de redirección después de que el usuario inicia sesión correctamente
                        .permitAll() //Permitimos todas las visitas a la página de login
                );

        http.
                logout(logout -> logout
                        //.logoutUrl("/logout")
                        //Para en caso de logout correcto redirija a una página en concreto
                        // .logoutSuccessUrl("/")
                        // Establece la ruta para procesar la petición de cierre de sesión
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        //.permitAll()
                );

        return http.build();

    }

    /**
     * Método que crea un bean BCryptPasswordEncoder.
     *
     * @return BCryptPasswordEncoder Bean de codificación de contraseñas con BCrypt.
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    CustomUserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
}
