package com.example.prestamos.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarioprestamo")
public class UsuarioPrestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TipoPrestamos prestamo;

    @ManyToOne
    @JoinColumn(name="tipoprestamoid")
    private User usuario;

    @OneToMany
    @JoinColumn(name="usuarioid")
    List<User> usarios;

    @Column(name = "montoSolicitado")
    private int montoSolicitado;
    @Column(name = "cantidadCuotas")
    private int cantidadCuotas;

    public TipoPrestamos getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(TipoPrestamos prestamo) {
        this.prestamo = prestamo;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public List<User> getUsarios() {
        return usarios;
    }

    public void setUsarios(List<User> usarios) {
        this.usarios = usarios;
    }

    public int getMontoSolicitado() {
        return montoSolicitado;
    }

    public void setMontoSolicitado(int montoSolicitado) {
        this.montoSolicitado = montoSolicitado;
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public String getNombresCodeudor() {
        return nombresCodeudor;
    }

    public void setNombresCodeudor(String nombresCodeudor) {
        this.nombresCodeudor = nombresCodeudor;
    }

    public String getCelularCodeudor() {
        return celularCodeudor;
    }

    public void setCelularCodeudor(String celularCodeudor) {
        this.celularCodeudor = celularCodeudor;
    }

    @Column(name = "nombresCodeudor")
    private String nombresCodeudor;
    @Column(name = "celularCodeudor")
    private String celularCodeudor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
