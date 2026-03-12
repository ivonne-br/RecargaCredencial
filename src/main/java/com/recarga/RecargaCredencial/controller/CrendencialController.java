package com.recarga.RecargaCredencial.controller;

import com.recarga.RecargaCredencial.dto.AlumnoDTO;
import com.recarga.RecargaCredencial.dto.CredencialDTO;
import com.recarga.RecargaCredencial.service.CredencialService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CrendencialController {

    private final CredencialService credencialService;

    private CrendencialController(CredencialService credencialService){

        this.credencialService = credencialService;
    }

    @GetMapping("/credencial")
    public List<CredencialDTO> findAll(){
        return credencialService.findAll();
    }

    // Obtener credencial por id
    @GetMapping("/credencial/{id}")
    public CredencialDTO findById(@PathVariable String matricula){
        return credencialService.findById(matricula)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Credencial no encontrada: " + matricula
                ));
    }
    // Crear Credencial
    @PostMapping("/credencial")
    public CredencialDTO create(@RequestBody CredencialDTO dto){
        return credencialService.save(dto);
    }


    // Actualizar credencial
    @PutMapping("/alumno/{matricula}")
    public void update(@PathVariable String matricula, @RequestBody CredencialDTO dto){
        credencialService.update(matricula,dto);
    }


    // Eliminar por id
    @DeleteMapping("/credencial/{matricula}")
    public void deleteById(@PathVariable String matricula){
        credencialService.deleteById(matricula);
    }



}
