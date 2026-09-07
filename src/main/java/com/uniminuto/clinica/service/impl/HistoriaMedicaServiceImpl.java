package com.uniminuto.clinica.service.impl;

import com.uniminuto.clinica.dto.HistoriaMedicaDTO;
import com.uniminuto.clinica.dto.HistoriaMedicaRequestDTO;
import com.uniminuto.clinica.exception.ResourceNotFoundException;
import com.uniminuto.clinica.model.HistoriaMedica;
import com.uniminuto.clinica.repository.HistoriaMedicaRepository;
import com.uniminuto.clinica.service.HistoriaMedicaService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementacion de {@link HistoriaMedicaService}.
 */
@Service
public class HistoriaMedicaServiceImpl implements HistoriaMedicaService {

    private final HistoriaMedicaRepository historiaMedicaRepository;

    /**
     * Constructor con inyeccion de dependencias.
     *
     * @param historiaMedicaRepository repositorio de historias medicas
     */
    public HistoriaMedicaServiceImpl(HistoriaMedicaRepository historiaMedicaRepository) {
        this.historiaMedicaRepository = historiaMedicaRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HistoriaMedicaDTO crear(HistoriaMedicaRequestDTO request) {
        HistoriaMedica historia = new HistoriaMedica();
        historia.setPacienteId(request.getPacienteId());
        historia.setFechaCreacion(LocalDateTime.now());
        HistoriaMedica guardada = historiaMedicaRepository.save(historia);
        return convertirADTO(guardada);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<HistoriaMedicaDTO> listar() {
        return historiaMedicaRepository.findAll().stream().map(this::convertirADTO).toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HistoriaMedicaDTO obtenerPorId(Long id) {
        HistoriaMedica historia = buscarOLanzarError(id);
        return convertirADTO(historia);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HistoriaMedicaDTO actualizar(Long id, HistoriaMedicaRequestDTO request) {
        HistoriaMedica historia = buscarOLanzarError(id);
        historia.setPacienteId(request.getPacienteId());
        HistoriaMedica actualizada = historiaMedicaRepository.save(historia);
        return convertirADTO(actualizada);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eliminar(Long id) {
        HistoriaMedica historia = buscarOLanzarError(id);
        historiaMedicaRepository.delete(historia);
    }

    /**
     * Busca una historia medica por id o lanza {@link ResourceNotFoundException}
     * si no existe.
     *
     * @param id identificador buscado
     * @return entidad encontrada
     */
    private HistoriaMedica buscarOLanzarError(Long id) {
        return historiaMedicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro la historia medica con id " + id));
    }

    /**
     * Convierte una entidad {@link HistoriaMedica} en su respectivo DTO.
     *
     * @param historia entidad a convertir
     * @return DTO con la informacion de la historia medica
     */
    private HistoriaMedicaDTO convertirADTO(HistoriaMedica historia) {
        return new HistoriaMedicaDTO(historia.getId(), historia.getPacienteId(), historia.getFechaCreacion());
    }
}
