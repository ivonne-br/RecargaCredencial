package com.recarga.RecargaCredencial.repository;

import com.recarga.RecargaCredencial.entity.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredencialRepository extends JpaRepository<Credencial, String> {
}
