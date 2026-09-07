package com.uniminuto.clinica.service.impl;

import com.uniminuto.clinica.dto.FormulaMedicaDTO;
import com.uniminuto.clinica.model.FormulaMedica;
import com.uniminuto.clinica.repository.FormulaMedicaRepository;
import com.uniminuto.clinica.service.FormulaMedicaService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementacion de {@link FormulaMedicaService}.
 */
@Service
public class FormulaMedicaServiceImpl implements FormulaMedicaService {

    private final FormulaMedicaRepository formulaMedicaRepository;

    /**
     * Constructor con inyeccion de dependencias.
     *
     * @param formulaMedicaRepository repositorio de formulas medicas
     */
    public FormulaMedicaServiceImpl(FormulaMedicaRepository formulaMedicaRepository) {
        this.formulaMedicaRepository = formulaMedicaRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<FormulaMedicaDTO> listarFormulas() {
        List<FormulaMedica> formulas = formulaMedicaRepository.findAllByOrderByFechaCreacionRegistroDesc();
        return formulas.stream().map(this::convertirADTO).toList();
    }

    /**
     * Convierte una entidad {@link FormulaMedica} en su respectivo DTO.
     *
     * @param formula entidad a convertir
     * @return DTO con la informacion de la formula medica
     */
    private FormulaMedicaDTO convertirADTO(FormulaMedica formula) {
        return new FormulaMedicaDTO(
                formula.getId(),
                formula.getCitaId(),
                formula.getMedicamentoId(),
                formula.getDosis(),
                formula.getIndicaciones(),
                formula.getFechaCreacionRegistro(),
                formula.getFechaActualizacionRegistro()
        );
    }
}
