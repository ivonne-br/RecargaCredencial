package com.recarga.RecargaCredencial.controller;

import com.recarga.RecargaCredencial.dto.AlumnoDTO;
import com.recarga.RecargaCredencial.dto.CredencialDTO;
import com.recarga.RecargaCredencial.service.CredencialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/credencial/{matricula}")
    public CredencialDTO findById(@PathVariable("matricula") String matricula){
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
    @PutMapping("/credencial/{matricula}")
    public ResponseEntity<String> update(@PathVariable String matricula, @RequestBody CredencialDTO dto){
        credencialService.update(matricula,dto);
        return ResponseEntity.ok("Credencial actualizada correctamente: " + matricula);
    }


    // Eliminar por id
    @DeleteMapping("/credencial/{matricula}")
    public ResponseEntity<String> deleteById(@PathVariable String matricula){
        credencialService.deleteById(matricula);
        return ResponseEntity.ok("Credencial eliminada correctamente: " + matricula);
    }



}
