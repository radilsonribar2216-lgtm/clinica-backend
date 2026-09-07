package com.uniminuto.clinica.service.impl;

import com.uniminuto.clinica.dto.CitaDTO;
import com.uniminuto.clinica.dto.CitaRequestDTO;
import com.uniminuto.clinica.exception.ResourceNotFoundException;
import com.uniminuto.clinica.model.Cita;
import com.uniminuto.clinica.repository.CitaRepository;
import com.uniminuto.clinica.service.CitaService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementacion de {@link CitaService}.
 */
@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;

    /**
     * Constructor con inyeccion de dependencias.
     *
     * @param citaRepository repositorio de citas
     */
    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CitaDTO> filtrarCitasPorFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        if (fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException("La fechaInicio no puede ser posterior a la fechaFin");
        }
        List<Cita> citas = citaRepository.findByFechaHoraBetweenOrderByFechaHoraDesc(fechaInicio, fechaFin);
        return citas.stream().map(this::convertirADTO).toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CitaDTO crearCita(CitaRequestDTO request) {
        Cita cita = new Cita();
        mapearRequestAEntidad(request, cita);
        Cita citaGuardada = citaRepository.save(cita);
        return convertirADTO(citaGuardada);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CitaDTO actualizarCita(Long id, CitaRequestDTO request) {
        Cita citaExistente = citaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro la cita con id " + id));
        mapearRequestAEntidad(request, citaExistente);
        Cita citaActualizada = citaRepository.save(citaExistente);
        return convertirADTO(citaActualizada);
    }

    /**
     * Copia los datos de un {@link CitaRequestDTO} hacia una entidad {@link Cita}.
     *
     * @param request datos de entrada
     * @param cita    entidad destino que sera modificada
     */
    private void mapearRequestAEntidad(CitaRequestDTO request, Cita cita) {
        cita.setClienteId(request.getClienteId());
        cita.setMascotaId(request.getMascotaId());
        cita.setMedicoId(request.getMedicoId());
        cita.setFechaHora(request.getFechaHora());
        cita.setEstado(request.getEstado());
        cita.setMotivo(request.getMotivo());
    }

    /**
     * Convierte una entidad {@link Cita} en su respectivo DTO.
     *
     * @param cita entidad a convertir
     * @return DTO con la informacion de la cita
     */
    private CitaDTO convertirADTO(Cita cita) {
        return new CitaDTO(
                cita.getId(),
                cita.getClienteId(),
                cita.getMascotaId(),
                cita.getMedicoId(),
                cita.getFechaHora(),
                cita.getEstado(),
                cita.getMotivo()
        );
    }
}
