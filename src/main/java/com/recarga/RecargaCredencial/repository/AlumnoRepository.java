package com.recarga.RecargaCredencial.repository;

import com.recarga.RecargaCredencial.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, String> {
}
