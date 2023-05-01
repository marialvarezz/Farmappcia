package farmappceuticos.farmappcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "name")
    String name;
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


    //Relaciones

    //Relación 1:1 con calendario
    @OneToOne(mappedBy = "userToAgenda")
    private Agenda agendaToUser;

    //Relación con UserRole
    @ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    @JoinTable(
            name="role_usuario",
            joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")})
    private List<Role> roles = new ArrayList<>();

    @OneToOne(mappedBy = "userToHistorialMedico")
    private MedicalHistory historialMedicoToUser;

    @OneToOne(mappedBy = "userToUserData")
    private UserData userDataToUser;

    //Relación 1:n con respuestas
    @OneToMany(mappedBy = "user" )
    private Set<Answers> answersToUser;

    @OneToMany(mappedBy = "userToMedicine", cascade = CascadeType.PERSIST )
    private Set<UserMedicine> userMedicines;

    //Relaciones con User
    @OneToMany(mappedBy = "tutorToUser")
    private Set<User> userToTutor;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "tutor_id")
    User tutorToUser;

    @OneToMany(mappedBy = "userToMedicineInc")
    private Set<UserMedicineInc> userMedicineIncs;


    //Constructors


}
