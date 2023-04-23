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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "reason")
    private String reason;

    //Relaciones


    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "medicineA_id")
    Medicine incToMedicinesA;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "medicineB_id")
    Medicine incToMedicinesB;








}