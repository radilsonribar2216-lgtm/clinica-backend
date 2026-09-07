package com.uniminuto.clinica.repository;

import com.uniminuto.clinica.model.AnotacionHistoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repositorio JPA para el acceso a datos de la entidad {@link AnotacionHistoria}.
 */
public interface AnotacionHistoriaRepository extends JpaRepository<AnotacionHistoria, Long> {

    /**
     * Filtra las anotaciones de historia medica cuya fecha se encuentra dentro
     * del rango indicado (inclusive), ordenadas desde la mas reciente hasta la mas antigua.
     *
     * @param fechaInicio fecha y hora inicial del rango de busqueda
     * @param fechaFin    fecha y hora final del rango de busqueda
     * @return lista de anotaciones dentro del rango, ordenada descendentemente por fecha
     */
    List<AnotacionHistoria> findByFechaBetweenOrderByFechaDesc(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
