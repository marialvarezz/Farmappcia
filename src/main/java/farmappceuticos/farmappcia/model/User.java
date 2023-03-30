package farmappceuticos.farmappcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String email;
    private String password;
    private LocalDate birthDate;
    private LocalDateTime registrationDateTime;
    private LocalDateTime updateDateTime;
    private Integer tutor;


    //Constructors


    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password, LocalDate birthDate, LocalDateTime registrationDateTime, LocalDateTime updateDateTime, Integer tutor) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.registrationDateTime = registrationDateTime;
        this.updateDateTime = updateDateTime;
        this.tutor = tutor;
    }
}
