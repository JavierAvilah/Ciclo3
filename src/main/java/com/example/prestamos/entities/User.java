package com.example.prestamos.entities;

import javax.persistence.*;

@Entity // Convierte clase en entidad
@Table (name = "users") // Nombre que va a tener la tabla
public class User {

    @Id // llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // genere el valor automaticamente
    private int id;

    @Column(name = "nombres") // asignar como columna y poner nombre de columna
    private  String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "edad")
    private int edad;
    @Column(name = "numeroDocumento")
    private  String numeroDocumento;

    @ManyToOne
    @JoinColumn(name = "tipodocumenoid")
    private TipoDocumento tipoDocumento;

    @OneToOne
    @JoinColumn(name = "iddireccion")
    private Direccion direccion;

    @Column(name = "perfil")
    private EnumPerfiles perfil;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Column (name = "correo")
    private String correo;

    @Column(name = "password", length = 200)
    private String password;
    public int getId() {
        return id;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public EnumPerfiles getPerfil() {
        return perfil;
    }

    public void setPerfil(EnumPerfiles perfil) {
        this.perfil = perfil;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}
