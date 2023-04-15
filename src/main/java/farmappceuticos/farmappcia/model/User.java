package farmappceuticos.farmappcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
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

    //Relación 1:1 con calendario
    @OneToOne(mappedBy = "userToCalendar")
    private Calendar calendarToUser;

    //Relación con UserRole
    @OneToMany(mappedBy = "userToRole")
    private Set<UserRole> userRolesToUser;

    @OneToOne(mappedBy = "userToHistorialMedico")
    private MedicalHistory historialMedicoToUser;

    @OneToOne(mappedBy = "userToUserData")
    private UserData userDataToUser;

    //Relación 1:n con respuestas
    @OneToMany(mappedBy = "userToAnswers" , fetch = FetchType.EAGER)
    private Set<Answers> answersToUser;

    @OneToMany(mappedBy = "userToMedicine", cascade = CascadeType.PERSIST )
    private Set<UserMedicine> userMedicines;

    //Relaciones con User
    @OneToMany(mappedBy = "")
    private Set<User> userToTutor;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "tutor_id")
    User tutorToUser;


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
