package com.example.jpa_formacion.model;



import jakarta.persistence.*;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;


@Entity
@Table(name = "cliente")
public class Cliente  implements Serializable {
    @Id
    @Column(name ="codigo_cliente")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column (name ="nombre_cliente",length = 50)
    private String nombreCliente;
    @Column (name ="nombre_contacto",length = 30)
    private String nombreContacto;
    @Column (name ="apellido_contacto",length = 30)
    private String apellidoContacto;
    @Column (name ="telefono",length = 15)
    private String telefono	;
    @Column (name ="fax",length = 15)
    private String fax;
    @Column (name ="linea_direccion1",length = 50)
    private String lineaDireccion1;
    @Column (name ="linea_direccion2",length = 50)
    private String lineaDireccion2;
    @Column (name ="ciudad",length = 50)
    private String ciudad;
    @Column (name ="region",length = 50)
    private String region;
    @Column (name ="pais",length = 50)
    private String pais;
    @Column (name ="codigo_postal",length = 10)
    private String codigoPostal;
    @Column (name ="codigo_empleado_rep_ventas")
    private int codigoEmpleado_rep_ventas;
    @Column (name ="limite_credito")
    private Float limiteCredito;

    @Column (name ="limite_credito_min")
    private Float limiteCreditoMin;

    @Column (name ="limite_credito_max")
    private Float limiteCreditoMax;

    @Column (name ="limite_credito_max_1")
    private Float limiteCreditoMax1;


    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_empleado")
    Empleado empleado;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getApellidoContacto() {
        return apellidoContacto;
    }

    public void setApellidoContacto(String apellidoContacto) {
        this.apellidoContacto = apellidoContacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getLineaDireccion1() {
        return lineaDireccion1;
    }

    public void setLineaDireccion1(String lineaDireccion1) {
        this.lineaDireccion1 = lineaDireccion1;
    }

    public String getLineaDireccion2() {
        return lineaDireccion2;
    }

    public void setLineaDireccion2(String lineaDireccion2) {
        this.lineaDireccion2 = lineaDireccion2;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getCodigoEmpleado_rep_ventas() {
        return codigoEmpleado_rep_ventas;
    }

    public void setCodigoEmpleado_rep_ventas(int codigoEmpleado_rep_ventas) {
        this.codigoEmpleado_rep_ventas = codigoEmpleado_rep_ventas;
    }

    public Float getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Float limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Float getLimiteCreditoMin() {
        return limiteCreditoMin;
    }

    public void setLimiteCreditoMin(Float limiteCreditoMin) {
        this.limiteCreditoMin = limiteCreditoMin;
    }

    public Float getLimiteCreditoMax() {
        return limiteCreditoMax;
    }

    public void setLimiteCreditoMax(Float limiteCreditoMax) {
        this.limiteCreditoMax = limiteCreditoMax;
    }

    public Cliente() {

    }

    public Cliente(long id, String nombreCliente, String nombreContacto, String apellidoContacto, String telefono, String fax, String lineaDireccion1, String lineaDireccion2, String ciudad, String region, String pais, String codigoPostal, int codigoEmpleado_rep_ventas, Float limiteCredito, Empleado empleado) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.nombreContacto = nombreContacto;
        this.apellidoContacto = apellidoContacto;
        this.telefono = telefono;
        this.fax = fax;
        this.lineaDireccion1 = lineaDireccion1;
        this.lineaDireccion2 = lineaDireccion2;
        this.ciudad = ciudad;
        this.region = region;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
        this.codigoEmpleado_rep_ventas = codigoEmpleado_rep_ventas;
        this.limiteCredito = limiteCredito;
        this.empleado = empleado;
    }
}
