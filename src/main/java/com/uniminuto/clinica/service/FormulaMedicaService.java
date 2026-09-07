package com.uniminuto.clinica.service;

import com.uniminuto.clinica.dto.FormulaMedicaDTO;

import java.util.List;

/**
 * Servicio encargado de la logica de negocio relacionada con las
 * formulas medicas del inventario.
 */
public interface FormulaMedicaService {

    /**
     * Lista todas las formulas medicas ordenadas por fecha de creacion,
     * de la mas reciente a la mas antigua.
     *
     * @return lista de formulas medicas
     */
    List<FormulaMedicaDTO> listarFormulas();
}
