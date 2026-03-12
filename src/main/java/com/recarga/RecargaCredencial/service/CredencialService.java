package com.recarga.RecargaCredencial.service;
import com.recarga.RecargaCredencial.dto.CredencialDTO;

import java.util.List;
import java.util.Optional;

public interface CredencialService {
    List<CredencialDTO> findAll();
    Optional<CredencialDTO> findById(String matricula);
    CredencialDTO save(CredencialDTO dto);
    void update(String matricula, CredencialDTO dto);
    void deleteById(String matricula);
}
