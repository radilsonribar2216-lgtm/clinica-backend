package com.uniminuto.clinica.controller;

import com.uniminuto.clinica.dto.CitaDTO;
import com.uniminuto.clinica.dto.CitaRequestDTO;
import com.uniminuto.clinica.service.CitaService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Controlador REST que expone los servicios relacionados con las
 * citas de la clinica veterinaria.
 *
 * <p>Requerimientos 2, 3 y 4: filtrar citas por rango de fechas,
 * crear una nueva cita y actualizar una cita existente.</p>
 */
@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaService citaService;

    /**
     * Constructor con inyeccion de dependencias.
     *
     * @param citaService servicio de citas
     */
    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    /**
     * Filtra las citas del sistema dentro de un rango de fechas, ordenadas
     * de la mas reciente a la mas antigua.
     *
     * @param fechaInicio fecha y hora inicial, formato {@code yyyy-MM-dd'T'HH:mm:ss}
     * @param fechaFin    fecha y hora final, formato {@code yyyy-MM-dd'T'HH:mm:ss}
     * @return lista de citas encontradas dentro del rango con codigo HTTP 200
     */
    @GetMapping
    public ResponseEntity<List<CitaDTO>> filtrarCitas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin) {
        return ResponseEntity.ok(citaService.filtrarCitasPorFecha(fechaInicio, fechaFin));
    }

    /**
     * Crea una nueva cita en el sistema.
     *
     * @param request datos de la nueva cita, validados automaticamente
     * @return DTO de la cita creada con codigo HTTP 201
     */
    @PostMapping
    public ResponseEntity<CitaDTO> crearCita(@Valid @RequestBody CitaRequestDTO request) {
        CitaDTO citaCreada = citaService.crearCita(request);
        return ResponseEntity.status(201).body(citaCreada);
    }

    /**
     * Actualiza una cita existente identificada por su id.
     *
     * @param id      identificador de la cita a actualizar
     * @param request nuevos datos de la cita, validados automaticamente
     * @return DTO de la cita actualizada con codigo HTTP 200
     */
    @PutMapping("/{id}")
    public ResponseEntity<CitaDTO> actualizarCita(@PathVariable Long id, @Valid @RequestBody CitaRequestDTO request) {
        return ResponseEntity.ok(citaService.actualizarCita(id, request));
    }
}
