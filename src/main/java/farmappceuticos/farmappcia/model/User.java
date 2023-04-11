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
    @Column(name="id")
    private Integer id;
    @Column(name="username")
    private String username;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="birthDate")
    private LocalDate birthDate;
    @Column(name="registrationDateTime")
    private LocalDateTime registrationDateTime;
    @Column(name="updeteDateTime")
    private LocalDateTime updateDateTime;
    @Column(name="tutor")
    private Integer tutor;

    //Relaciones
    @OneToOne(mappedBy = "user")
    private Calendar calendar;




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
