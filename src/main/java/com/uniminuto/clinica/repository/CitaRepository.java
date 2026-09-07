package com.uniminuto.clinica.repository;

import com.uniminuto.clinica.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repositorio JPA para el acceso a datos de la entidad {@link Cita}.
 */
public interface CitaRepository extends JpaRepository<Cita, Long> {

    /**
     * Filtra las citas cuya fecha y hora se encuentran dentro del rango
     * indicado (inclusive), ordenadas desde la mas reciente hasta la mas antigua.
     *
     * @param fechaInicio fecha y hora inicial del rango de busqueda
     * @param fechaFin    fecha y hora final del rango de busqueda
     * @return lista de citas dentro del rango, ordenada descendentemente por fecha_hora
     */
    List<Cita> findByFechaHoraBetweenOrderByFechaHoraDesc(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
