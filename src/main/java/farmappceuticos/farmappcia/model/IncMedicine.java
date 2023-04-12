package farmappceuticos.farmappcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "incmedicine")
public class IncMedicine {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "reason")
    private String reason;

    //Relaciones


    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "medicineA_id")
    Medicine medicine;

    // TODO: 12/04/2023 Queda por ver cómo hacer la segunta relación ManyToOne con tabla Medicine 






}