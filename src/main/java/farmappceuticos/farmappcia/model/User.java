package farmappceuticos.farmappcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

    @OneToMany(mappedBy = "user")
    private Set<MedicalHistory> medicalHistories;

    @OneToOne(mappedBy = "userToUserData")
    private UserData userDataToUser;

    //Relación 1:n con respuestas
    @OneToMany(mappedBy = "user" )
    private Set<Answers> answersToUser;

    @OneToMany(mappedBy = "userToMedicine")
    private Set<UserMedicine> userMedicines;



    @OneToMany(mappedBy = "userToMedicineInc",cascade= CascadeType.ALL)
    private Set<UserMedicineInc> userMedicineIncs;



    //Relaciones con User

    //TUTOR DEL USUARIO

    private String tutorMail;


    //USUARIOS DEL TUTOR


    //Constructors


}
