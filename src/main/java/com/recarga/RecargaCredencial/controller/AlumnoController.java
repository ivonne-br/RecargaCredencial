package com.recarga.RecargaCredencial.controller;

import com.recarga.RecargaCredencial.entity.Alumno;
import com.recarga.RecargaCredencial.service.AlumnoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlumnoController {
    private final AlumnoService alumnoService;

    private AlumnoController(AlumnoService alumnoService){
        this.alumnoService = alumnoService;
    }

    @GetMapping("/alumno")
    public List<AlumnoDTO> findAll(){
        return alumnoService.findAlll();
    }

}
