package com.uniminuto.clinica.service.impl;

import com.uniminuto.clinica.dto.AnotacionHistoriaDTO;
import com.uniminuto.clinica.dto.AnotacionHistoriaRequestDTO;
import com.uniminuto.clinica.exception.ResourceNotFoundException;
import com.uniminuto.clinica.model.AnotacionHistoria;
import com.uniminuto.clinica.repository.AnotacionHistoriaRepository;
import com.uniminuto.clinica.service.AnotacionHistoriaService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementacion de {@link AnotacionHistoriaService}.
 */
@Service
public class AnotacionHistoriaServiceImpl implements AnotacionHistoriaService {

    private final AnotacionHistoriaRepository anotacionHistoriaRepository;

    /**
     * Constructor con inyeccion de dependencias.
     *
     * @param anotacionHistoriaRepository repositorio de anotaciones de historia medica
     */
    public AnotacionHistoriaServiceImpl(AnotacionHistoriaRepository anotacionHistoriaRepository) {
        this.anotacionHistoriaRepository = anotacionHistoriaRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnotacionHistoriaDTO crear(AnotacionHistoriaRequestDTO request) {
        AnotacionHistoria anotacion = new AnotacionHistoria();
        anotacion.setHistoriaId(request.getHistoriaId());
        anotacion.setMedicoId(request.getMedicoId());
        anotacion.setDescripcion(request.getDescripcion());
        anotacion.setFecha(LocalDateTime.now());
        AnotacionHistoria guardada = anotacionHistoriaRepository.save(anotacion);
        return convertirADTO(guardada);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<AnotacionHistoriaDTO> listarPorFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        if (fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException("La fechaInicio no puede ser posterior a la fechaFin");
        }
        List<AnotacionHistoria> anotaciones =
                anotacionHistoriaRepository.findByFechaBetweenOrderByFechaDesc(fechaInicio, fechaFin);
        return anotaciones.stream().map(this::convertirADTO).toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnotacionHistoriaDTO actualizar(Long id, AnotacionHistoriaRequestDTO request) {
        AnotacionHistoria anotacion = anotacionHistoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro la anotacion con id " + id));
        anotacion.setHistoriaId(request.getHistoriaId());
        anotacion.setMedicoId(request.getMedicoId());
        anotacion.setDescripcion(request.getDescripcion());
        AnotacionHistoria actualizada = anotacionHistoriaRepository.save(anotacion);
        return convertirADTO(actualizada);
    }

    /**
     * Convierte una entidad {@link AnotacionHistoria} en su respectivo DTO.
     *
     * @param anotacion entidad a convertir
     * @return DTO con la informacion de la anotacion
     */
    private AnotacionHistoriaDTO convertirADTO(AnotacionHistoria anotacion) {
        return new AnotacionHistoriaDTO(
                anotacion.getId(),
                anotacion.getHistoriaId(),
                anotacion.getMedicoId(),
                anotacion.getFecha(),
                anotacion.getDescripcion()
        );
    }
}
