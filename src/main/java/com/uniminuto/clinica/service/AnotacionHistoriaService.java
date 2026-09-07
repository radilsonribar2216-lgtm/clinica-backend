package com.uniminuto.clinica.service;

import com.uniminuto.clinica.dto.AnotacionHistoriaDTO;
import com.uniminuto.clinica.dto.AnotacionHistoriaRequestDTO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Servicio encargado de la logica de negocio de las anotaciones de
 * historia medica. Segun los requerimientos, unicamente se exponen
 * las operaciones de crear, listar (con filtro de fechas) y actualizar.
 */
public interface AnotacionHistoriaService {

    /**
     * Crea una nueva anotacion de historia medica.
     *
     * @param request datos de la nueva anotacion
     * @return DTO de la anotacion creada
     */
    AnotacionHistoriaDTO crear(AnotacionHistoriaRequestDTO request);

    /**
     * Lista las anotaciones de historia medica filtradas por un rango de
     * fechas, ordenadas de la mas reciente a la mas antigua.
     *
     * @param fechaInicio fecha y hora inicial del rango
     * @param fechaFin    fecha y hora final del rango
     * @return lista de anotaciones dentro del rango
     */
    List<AnotacionHistoriaDTO> listarPorFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    /**
     * Actualiza una anotacion de historia medica existente.
     *
     * @param id      identificador de la anotacion a actualizar
     * @param request nuevos datos de la anotacion
     * @return DTO de la anotacion actualizada
     */
    AnotacionHistoriaDTO actualizar(Long id, AnotacionHistoriaRequestDTO request);
}
