package farmappceuticos.farmappcia.config;

import farmappceuticos.farmappcia.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableMethodSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests( authorize -> authorize

                //Permitimos todas las visitas a la pagina principal
                .requestMatchers("","/","/medicamentos/","/404","/403","/500","/error").permitAll()
                //Permitimos todas las visitas a la pagina principal
                .requestMatchers("/registro","/registrarusuario").permitAll()
                //Permitimos la entrada a los css, js e imágenes
                .requestMatchers("/webjars/**","/vendor/**", "/js/**","/css/**","/img/**","/fonts/**","/favicon.ico").permitAll()
                .requestMatchers("*css", "*js").permitAll()
                //Permitimos todas las visitas a /public
                .requestMatchers("/aboutus").permitAll()

                .requestMatchers("/usuario/**").authenticated() //Permitimos únicamente las visitas de usuarios registrados a  /private
                .requestMatchers("/agenda/**","/usuario","/evento/**","/historialmedico/**","/usumedicamentosinc/**").authenticated()
                // Todas las request no filtradas hasta ahora, se rechazarán
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().hasRole("ADMIN")
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

//aa
}
