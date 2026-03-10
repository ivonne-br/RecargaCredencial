package com.recarga.RecargaCredencial.entity;

import jakarta.persistence.*;

@Entity
@Table(name="alumno")
public class Alumno {
    @Id
    @Column(name = "matricula", length = 20)
    private String matricula;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "correo_institucional", nullable = false, unique = true, length = 100)
    private String correoInstitucional;

    @Column(name = "licenciatura", nullable = false, length = 150)
    private String licenciatura;

    //@OneToOne(mappedBy = "alumno")
    //private Credencial credencial;

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }
    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getLicenciatura() {
        return licenciatura;
    }
    public void setLicenciatura(String licenciatura) {
        this.licenciatura = licenciatura;
    }
}
