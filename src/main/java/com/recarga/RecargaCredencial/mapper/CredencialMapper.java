package com.recarga.RecargaCredencial.mapper;

import com.recarga.RecargaCredencial.dto.CredencialDTO;
import com.recarga.RecargaCredencial.entity.Credencial;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {CredencialMapper.class}
)
public interface CredencialMapper {

    @Mapping(source = "matricula", target = "matricula")
        CredencialDTO toDTO(Credencial credencial);

    @Mapping(target = "matricula", ignore = true)
        Credencial toEntity(CredencialDTO credencialDTO);
}
