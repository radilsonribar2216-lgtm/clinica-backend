package com.uniminuto.clinica.service;

import com.uniminuto.clinica.dto.CitaDTO;
import com.uniminuto.clinica.dto.CitaRequestDTO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Servicio encargado de la logica de negocio relacionada con las citas
 * de la clinica veterinaria.
 */
public interface CitaService {

    /**
     * Filtra las citas dentro de un rango de fechas, ordenadas de la
     * mas reciente a la mas antigua.
     *
     * @param fechaInicio fecha y hora inicial del rango
     * @param fechaFin    fecha y hora final del rango
     * @return lista de citas encontradas dentro del rango
     */
    List<CitaDTO> filtrarCitasPorFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    /**
     * Crea una nueva cita en el sistema.
     *
     * @param request datos de la nueva cita
     * @return DTO de la cita creada, incluyendo su identificador generado
     */
    CitaDTO crearCita(CitaRequestDTO request);

    /**
     * Actualiza una cita existente identificada por su id.
     *
     * @param id      identificador de la cita a actualizar
     * @param request nuevos datos de la cita
     * @return DTO de la cita actualizada
     */
    CitaDTO actualizarCita(Long id, CitaRequestDTO request);
}
