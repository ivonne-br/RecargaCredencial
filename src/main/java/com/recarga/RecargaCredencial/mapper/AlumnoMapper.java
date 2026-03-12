package com.recarga.RecargaCredencial.mapper;

import com.recarga.RecargaCredencial.dto.AlumnoDTO;
import com.recarga.RecargaCredencial.entity.Alumno;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {AlumnoMapper.class}
)
public interface AlumnoMapper {
    @Mapping(source = "matricula", target = "matricula")
    AlumnoDTO toAlumnoDTO (Alumno alumno);

    Alumno toAlumno (AlumnoDTO alumnoDTO);
}
