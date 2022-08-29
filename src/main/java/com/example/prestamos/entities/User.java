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

    public int getId() {
        return id;
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
