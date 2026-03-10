package com.recarga.RecargaCredencial.dto;

public class AlumnoDTO {
    private String matricula;
    private String nombre;
    private String correoInstitucional;
    private String licenciatura;

    //private CredenncialDTO credencial;

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

//    public CredencialDTO getCredencial(){
//        return credencial:
//    }
    //public void setCredencial(CredencialDTO credencial){
    //this.credencial = credencial;
    //}
}
