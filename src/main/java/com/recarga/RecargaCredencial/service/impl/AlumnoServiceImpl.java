package com.recarga.RecargaCredencial.service.impl;

// entity, mapper, repository de credencial
import com.recarga.RecargaCredencial.dto.AlumnoDTO;
import com.recarga.RecargaCredencial.entity.Alumno;
import com.recarga.RecargaCredencial.mapper.AlumnoMapper;
import com.recarga.RecargaCredencial.repository.AlumnoRepository;
import com.recarga.RecargaCredencial.service.AlumnoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class AlumnoServiceImpl implements AlumnoService {
    private final AlumnoRepository alumnoRepository;
    private final AlumnoMapper alumnoMapper;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository, AlumnoMapper alumnoMapper) {
        this.alumnoRepository = alumnoRepository;
        this.alumnoMapper = alumnoMapper;
    }

    @Override
    public List<AlumnoDTO> findAll(){
        return alumnoRepository.findAll()
                .stream()
                .map(alumnoMapper::toAlumnoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AlumnoDTO> findById(String matricula) {
        return alumnoRepository.findById(matricula)
                .map(alumnoMapper::toAlumnoDTO);
    }

    @Override
    public AlumnoDTO save(AlumnoDTO dto) {
        // credencial !!
        //Credencial credencial = null;
        //if (dto.getCredencial() != null && dto.getCredencial().geteId_credencial (matricula)!!

        Alumno alumno = alumnoMapper.toAlumno(dto);
        //alumno.setCredencial(credencial);

        alumno  = alumnoRepository.save(alumno);
        return alumnoMapper.toAlumnoDTO(alumno);
    }

    @Override
    public void update(String matricula, AlumnoDTO dto) {
        Alumno alumno = alumnoRepository.findById(matricula)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Alumno no encontrado: " + matricula));
        // Credencial

        alumno.setNombre(dto.getNombre());
        alumno.setCorreoInstitucional(dto.getCorreoInstitucional());
        alumno.setLicenciatura(alumno.getLicenciatura());
        alumnoRepository.save(alumno);
    }

    @Override
    public void deleteById(String matricula) {
        if (!alumnoRepository.existsById(matricula))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Alumno no encontrado: " + matricula);
        alumnoRepository.deleteById(matricula);
    }
}
