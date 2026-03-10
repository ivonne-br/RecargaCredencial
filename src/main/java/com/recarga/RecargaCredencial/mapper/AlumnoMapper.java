package com.recarga.RecargaCredencial.mapper;

import com.recarga.RecargaCredencial.dto.AlumnoDTO;
import com.recarga.RecargaCredencial.entity.Alumno;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {CredencialMapper.class}
)
public interface AlumnoMapper {
    @Mapping(source = "matricula", target = matricula)
    AlumnoDTO toAlumnoDTO (Alumno alumno);

    @Mapping(target = "matricula", ignore = true)
    Alumno toAlumno (AlumnoDTO alumnoDTO);
}
