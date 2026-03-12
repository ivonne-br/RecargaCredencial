package com.recarga.RecargaCredencial.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="credencial")
public class Credencial {

    @Id
    @Column(name = "matricula", length = 20)
    private String matricula;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_expedicion", nullable = false)
    private Date fechaExpedicion;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_vencimiento", nullable = false)
    private Date fechaVencimiento;

    @Column(name = "saldo", nullable = false)
    private Double saldo;

    @Transient
    private Alumno alumno;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}
