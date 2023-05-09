package farmappceuticos.farmappcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posiblesrespuestas")
public class PosiblesRespuestas {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="textorespuesta")
    private String textorespuesta;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL , mappedBy = "posiblesRespuestas")
    private Set<Questionsjma> questionsjmas = new HashSet<>();
}
