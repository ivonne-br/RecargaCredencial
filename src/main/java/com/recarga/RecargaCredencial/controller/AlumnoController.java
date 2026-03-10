package com.recarga.RecargaCredencial.controller;

import com.recarga.RecargaCredencial.dto.AlumnoDTO;
import com.recarga.RecargaCredencial.service.AlumnoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class AlumnoController {
    private final AlumnoService alumnoService;

    private AlumnoController(AlumnoService alumnoService){
        this.alumnoService = alumnoService;
    }

    // Obtener todos los alumnos
    @GetMapping("/alumno")
    public List<AlumnoDTO> findAll(){
        return alumnoService.findAll();
    }

    // Obtener alumno por id
    @GetMapping("/alumno/{id}")
    public AlumnoDTO findById(@PathVariable String matricula){
        return alumnoService.findById(matricula)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Alumno no encontrado: " + matricula
                ));
    }

    // Crear alumno
    @PostMapping("/alumno")
    public AlumnoDTO create(@RequestBody AlumnoDTO dto){
        return alumnoService.save(dto);
    }

    // Actualizar alumno
    @PutMapping("/alumno/{id}")
    public void update(@PathVariable String matricula, @RequestBody AlumnoDTO dto){
        alumnoService.update(matricula,dto);
    }

    // Eliminar por id
    @DeleteMapping("alumno/{id}")
    public void deleteById(@PathVariable String matricula){
        alumnoService.deleteById(matricula);
    }
}
