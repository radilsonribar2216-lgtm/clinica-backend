package com.uniminuto.clinica.service;

import com.uniminuto.clinica.dto.HistoriaMedicaDTO;
import com.uniminuto.clinica.dto.HistoriaMedicaRequestDTO;

import java.util.List;

/**
 * Servicio encargado de la logica de negocio (CRUD) de la entidad
 * historia medica.
 */
public interface HistoriaMedicaService {

    /**
     * Crea una nueva historia medica.
     *
     * @param request datos de la nueva historia medica
     * @return DTO de la historia medica creada
     */
    HistoriaMedicaDTO crear(HistoriaMedicaRequestDTO request);

    /**
     * Lista todas las historias medicas registradas.
     *
     * @return lista de historias medicas
     */
    List<HistoriaMedicaDTO> listar();

    /**
     * Obtiene una historia medica por su identificador.
     *
     * @param id identificador de la historia medica
     * @return DTO de la historia medica encontrada
     */
    HistoriaMedicaDTO obtenerPorId(Long id);

    /**
     * Actualiza una historia medica existente.
     *
     * @param id      identificador de la historia medica a actualizar
     * @param request nuevos datos de la historia medica
     * @return DTO de la historia medica actualizada
     */
    HistoriaMedicaDTO actualizar(Long id, HistoriaMedicaRequestDTO request);

    /**
     * Elimina una historia medica por su identificador.
     *
     * @param id identificador de la historia medica a eliminar
     */
    void eliminar(Long id);
}
