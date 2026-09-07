package com.uniminuto.clinica.repository;

import com.uniminuto.clinica.model.HistoriaMedica;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA para el acceso a datos de la entidad {@link HistoriaMedica}.
 */
public interface HistoriaMedicaRepository extends JpaRepository<HistoriaMedica, Long> {
}
