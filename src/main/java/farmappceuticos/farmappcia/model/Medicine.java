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
@Table(name = "medicine")
public class Medicine {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="image")
    private String image;

    @Column(name="components")
    private String components;

    @Column(name="administer")
    private String administer;

    @Column(name="efects")
    private String efects;

    @Column(name="misc")
    private String misc;

    //Relaciones


    @OneToMany(mappedBy = "medicineToMedicine")
    private Set<UserMedicine> userMedicines;

    @OneToMany(mappedBy = "incToMedicinesA")
    private Set<IncMedicine> incMedicinesA;

    @OneToMany(mappedBy = "incToMedicinesB")
    private Set<IncMedicine> incMedicinesB;








}