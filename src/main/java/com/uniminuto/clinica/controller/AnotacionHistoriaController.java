package com.uniminuto.clinica.controller;

import com.uniminuto.clinica.dto.AnotacionHistoriaDTO;
import com.uniminuto.clinica.dto.AnotacionHistoriaRequestDTO;
import com.uniminuto.clinica.service.AnotacionHistoriaService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Controlador REST que expone los servicios de crear, listar (con filtro
 * de fechas) y actualizar anotaciones de historia medica.
 *
 * <p>Requerimiento 5 (parte 2): servicios de anotacion_historia.</p>
 */
@RestController
@RequestMapping("/api/anotaciones")
public class AnotacionHistoriaController {

    private final AnotacionHistoriaService anotacionHistoriaService;

    /**
     * Constructor con inyeccion de dependencias.
     *
     * @param anotacionHistoriaService servicio de anotaciones de historia medica
     */
    public AnotacionHistoriaController(AnotacionHistoriaService anotacionHistoriaService) {
        this.anotacionHistoriaService = anotacionHistoriaService;
    }

    /**
     * Crea una nueva anotacion de historia medica.
     *
     * @param request datos de la nueva anotacion
     * @return DTO de la anotacion creada con codigo HTTP 201
     */
    @PostMapping
    public ResponseEntity<AnotacionHistoriaDTO> crear(@Valid @RequestBody AnotacionHistoriaRequestDTO request) {
        AnotacionHistoriaDTO creada = anotacionHistoriaService.crear(request);
        return ResponseEntity.status(201).body(creada);
    }

    /**
     * Lista las anotaciones de historia medica filtradas por un rango de
     * fechas, ordenadas de la mas reciente a la mas antigua.
     *
     * @param fechaInicio fecha y hora inicial, formato {@code yyyy-MM-dd'T'HH:mm:ss}
     * @param fechaFin    fecha y hora final, formato {@code yyyy-MM-dd'T'HH:mm:ss}
     * @return lista de anotaciones dentro del rango con codigo HTTP 200
     */
    @GetMapping
    public ResponseEntity<List<AnotacionHistoriaDTO>> listarPorFecha(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin) {
        return ResponseEntity.ok(anotacionHistoriaService.listarPorFecha(fechaInicio, fechaFin));
    }

    /**
     * Actualiza una anotacion de historia medica existente.
     *
     * @param id      identificador de la anotacion a actualizar
     * @param request nuevos datos de la anotacion
     * @return DTO de la anotacion actualizada con codigo HTTP 200
     */
    @PutMapping("/{id}")
    public ResponseEntity<AnotacionHistoriaDTO> actualizar(@PathVariable Long id,
                                                             @Valid @RequestBody AnotacionHistoriaRequestDTO request) {
        return ResponseEntity.ok(anotacionHistoriaService.actualizar(id, request));
    }
}
