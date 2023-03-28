package com.example.jpa_formacion.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {
  @Id
  @Column (name ="ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column (name ="nombre",length = 50)
  private String nombre;
  @Column (name ="apellido1",length = 50 )
  private String apellido1;
  @Column (name ="apellido2",length = 50)
  private String apellido2;
  @Column (name ="extension",length = 10  )
  private String extension;
  @Column (name ="email",length = 100  )
  private String email;
  @Column (name ="puesto",length =  50)
  private String puesto;


  @OneToMany(mappedBy = "empleado" , fetch = FetchType.EAGER)
  private Set<Cliente> clientes;

  @OneToMany(mappedBy = "empleadoGaleria" )
  private Set<Galeria> galerias;

  @OneToMany(mappedBy = "empleadoGaleriaEmbed" )
  private Set<GaleriaEmbeddable> galeriaEmbeddables;
  //@ManyToOne
  //@JoinColumn(name = "codigo_oficina")
  //Oficina oficina;

  public Empleado() {

  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido1() {
    return apellido1;
  }

  public void setApellido1(String apellido1) {
    this.apellido1 = apellido1;
  }

  public String getApellido2() {
    return apellido2;
  }

  public void setApellido2(String apellido2) {
    this.apellido2 = apellido2;
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }




  public String getPuesto() {
    return puesto;
  }

  public void setPuesto(String puesto) {
    this.puesto = puesto;
  }

  public Set<Cliente> getClientes() {
    return clientes;
  }

  public void setClientes(Set<Cliente> clientes) {
    this.clientes = clientes;
  }

  public Empleado(long id, String nombre, String apellido1, String apellido2, String extension, String email, String puesto, Set<Cliente> cliente, Oficina oficina) {
    this.id = id;
    this.nombre = nombre;
    this.apellido1 = apellido1;
    this.apellido2 = apellido2;
    this.extension = extension;
    this.email = email;

    this.puesto = puesto;
    this.clientes = cliente;
  }
}
