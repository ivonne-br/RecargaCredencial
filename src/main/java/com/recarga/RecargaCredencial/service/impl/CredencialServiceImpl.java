package com.recarga.RecargaCredencial.service.impl;

import com.recarga.RecargaCredencial.dto.AlumnoDTO;
import com.recarga.RecargaCredencial.dto.CredencialDTO;
import com.recarga.RecargaCredencial.entity.Alumno;
import com.recarga.RecargaCredencial.entity.Credencial;
import com.recarga.RecargaCredencial.mapper.AlumnoMapper;
import com.recarga.RecargaCredencial.mapper.CredencialMapper;
import com.recarga.RecargaCredencial.repository.AlumnoRepository;
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
    private final AlumnoRepository alumnoRepository;
    private final AlumnoMapper alumnoMapper;

    public CredencialServiceImpl(CredencialRepository credencialRepository, CredencialMapper credencialMapper, AlumnoRepository alumnoRepository, AlumnoMapper alumnoMapper){
        this.credencialRepository = credencialRepository;
        this.credencialMapper = credencialMapper;
        this.alumnoRepository = alumnoRepository;
        this.alumnoMapper = alumnoMapper;
    }
    @Override
    public List<CredencialDTO> findAll(){
        return credencialRepository.findAll()
                .stream()
                .map(credencial -> {
                    CredencialDTO dto = credencialMapper.toCredencialDTO(credencial);
                    alumnoRepository.findById(credencial.getMatricula())
                            .map(alumnoMapper::toAlumnoDTO)
                            .ifPresent(dto::setAlumno);
                    return dto;
                })
                .collect(Collectors.toList());
    }
    @Override
    public Optional<CredencialDTO> findById(String matricula) {
        return credencialRepository.findById(matricula)
                .map(credencial -> {
                    CredencialDTO dto = credencialMapper.toCredencialDTO(credencial);
                    alumnoRepository.findById(matricula)
                            .map(alumnoMapper::toAlumnoDTO)
                            .ifPresent(dto::setAlumno);
                    return dto;
                });
    }

    @Override
    public CredencialDTO save(CredencialDTO dto) {
        // credencial !!
        //Credencial credencial = null;
        //if (dto.getCredencial() != null && dto.getCredencial().geteId_credencial (matricula)!!

        String matricula = dto.getMatricula();
        if (matricula == null && dto.getAlumno() != null) {
            matricula = dto.getAlumno().getMatricula();
        }
        if (matricula == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "matricula es obligatoria para crear credencial");
        }

        final String matriculaFinal = matricula;
        Alumno alumno = alumnoRepository.findById(matriculaFinal)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Alumno no encontrado: " + matriculaFinal));
        if (dto.getFechaExpedicion() == null || dto.getFechaVencimiento() == null || dto.getSaldo() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "fechaExpedicion, fechaVencimiento y saldo son obligatorios");
        }

        Credencial credencial = new Credencial();
        credencial.setMatricula(matricula);
        credencial.setAlumno(alumno);
        credencial.setFechaExpedicion(dto.getFechaExpedicion());
        credencial.setFechaVencimiento(dto.getFechaVencimiento());
        credencial.setSaldo(dto.getSaldo());

        Credencial saved = credencialRepository.save(credencial);
        CredencialDTO result = credencialMapper.toCredencialDTO(saved);
        result.setAlumno(alumnoMapper.toAlumnoDTO(alumno));
        return result;
    }

    @Override
    public void update(String matricula, CredencialDTO dto) {
        Credencial credencial = credencialRepository.findById(matricula)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Credencial no encontrado: " + matricula));
        // Credencial

        if (dto.getFechaExpedicion() != null) {
            credencial.setFechaExpedicion(dto.getFechaExpedicion());
        }
        if (dto.getFechaVencimiento() != null) {
            credencial.setFechaVencimiento(dto.getFechaVencimiento());
        }
        if (dto.getSaldo() != null) {
            credencial.setSaldo(dto.getSaldo());
        }
        credencialRepository.save(credencial);
    }

    @Override
    public void deleteById(String matricula) {
        if (!credencialRepository.existsById(matricula))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Credencial no encontrado: " + matricula);
        credencialRepository.deleteById(matricula);
    }
}


