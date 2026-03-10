package com.recarga.RecargaCredencial.service;

import com.recarga.RecargaCredencial.dto.AlumnoDTO;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {
    List<AlumnoDTO> findAll();
    Optional<AlumnoDTO> findById(String matricula);
    AlumnoDTO save(AlumnoDTO dto);
    void update(String matricula, AlumnoDTO dto);
    void deleteById(String matricula);
}
