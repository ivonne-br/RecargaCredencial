package com.recarga.RecargaCredencial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumnos")

public class AlumnoController {
    private final AlumnoService alumnoService;

    private AlumnoController(AlumnoService alumnoService){
        this.alumnoService = alumnoService;
    }

}
