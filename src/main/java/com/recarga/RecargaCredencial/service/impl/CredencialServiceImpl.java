package com.recarga.RecargaCredencial.service.impl;

import com.recarga.RecargaCredencial.dto.AlumnoDTO;
import com.recarga.RecargaCredencial.dto.CredencialDTO;
import com.recarga.RecargaCredencial.entity.Alumno;
import com.recarga.RecargaCredencial.entity.Credencial;
import com.recarga.RecargaCredencial.mapper.CredencialMapper;
import com.recarga.RecargaCredencial.repository.CredencialRepository;
import com.recarga.RecargaCredencial.service.CredencialService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CredencialServiceImpl implements CredencialService {

    private final CredencialRepository credencialRepository;
    private final CredencialMapper credencialMapper;

    public CredencialServiceImpl(CredencialRepository credencialRepository, CredencialMapper credencialMapper){
        this.credencialRepository = credencialRepository;
        this.credencialMapper = credencialMapper;
    }
    @Override
    public List<CredencialDTO> findAll(){
        return credencialRepository.findAll()
                .stream()
                .map(credencialMapper::toCredencialDTO)
                .collect(Collectors.toList());
    }
    @Override
    public Optional<CredencialDTO> findById(String matricula) {
        return credencialRepository.findById(matricula)
                .map(credencialMapper::toCredencialDTO);
    }

    @Override
    public CredencialDTO save(CredencialDTO dto) {
        // credencial !!
        //Credencial credencial = null;
        //if (dto.getCredencial() != null && dto.getCredencial().geteId_credencial (matricula)!!

        Credencial credencial = credencialMapper.toCredencialDTO(dto);
        //alumno.setCredencial(credencial);

        credencial  = credencialRepository.save(credencial);
        return credencialMapper.toCredencialDTO(alumno);
    }

    @Override
    public void update(String matricula, CredencialDTO dto) {
        Credencial credencial = credencialMapper.findById(matricula)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Credencial no encontrado: " + matricula));
        // Credencial

        credencial.setFechaExpedicion(dto.getFechaExpedicion());
        credencial.setFechaVencimiento(dto.getFechaVencimiento());
        credencial.setSaldo(credencial.getSaldo());
        credencialRepository.save(credencial);
    }

    @Override
    public void deleteById(String matricula) {
        if (!credencialRepository.existsById(matricula))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Credencial no encontrado: " + matricula);
        credencialRepository.deleteById(matricula);
    }
}


