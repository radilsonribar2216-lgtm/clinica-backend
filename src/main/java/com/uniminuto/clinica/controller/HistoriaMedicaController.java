package com.uniminuto.clinica.controller;

import com.uniminuto.clinica.dto.HistoriaMedicaDTO;
import com.uniminuto.clinica.dto.HistoriaMedicaRequestDTO;
import com.uniminuto.clinica.service.HistoriaMedicaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que expone el CRUD de la entidad historia medica.
 *
 * <p>Requerimiento 5 (parte 1): crear, listar, consultar y actualizar
 * historias medicas.</p>
 */
@RestController
@RequestMapping("/api/historias")
public class HistoriaMedicaController {

    private final HistoriaMedicaService historiaMedicaService;

    /**
     * Constructor con inyeccion de dependencias.
     *
     * @param historiaMedicaService servicio de historias medicas
     */
    public HistoriaMedicaController(HistoriaMedicaService historiaMedicaService) {
        this.historiaMedicaService = historiaMedicaService;
    }

    /**
     * Crea una nueva historia medica.
     *
     * @param request datos de la nueva historia medica
     * @return DTO de la historia medica creada con codigo HTTP 201
     */
    @PostMapping
    public ResponseEntity<HistoriaMedicaDTO> crear(@Valid @RequestBody HistoriaMedicaRequestDTO request) {
        HistoriaMedicaDTO creada = historiaMedicaService.crear(request);
        return ResponseEntity.status(201).body(creada);
    }

    /**
     * Lista todas las historias medicas registradas.
     *
     * @return lista de historias medicas con codigo HTTP 200
     */
    @GetMapping
    public ResponseEntity<List<HistoriaMedicaDTO>> listar() {
        return ResponseEntity.ok(historiaMedicaService.listar());
    }

    /**
     * Obtiene una historia medica por su identificador.
     *
     * @param id identificador de la historia medica
     * @return DTO de la historia medica encontrada con codigo HTTP 200
     */
    @GetMapping("/{id}")
    public ResponseEntity<HistoriaMedicaDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(historiaMedicaService.obtenerPorId(id));
    }

    /**
     * Actualiza una historia medica existente.
     *
     * @param id      identificador de la historia medica a actualizar
     * @param request nuevos datos de la historia medica
     * @return DTO de la historia medica actualizada con codigo HTTP 200
     */
    @PutMapping("/{id}")
    public ResponseEntity<HistoriaMedicaDTO> actualizar(@PathVariable Long id,
                                                          @Valid @RequestBody HistoriaMedicaRequestDTO request) {
        return ResponseEntity.ok(historiaMedicaService.actualizar(id, request));
    }

    /**
     * Elimina una historia medica por su identificador.
     *
     * @param id identificador de la historia medica a eliminar
     * @return respuesta vacia con codigo HTTP 204
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        historiaMedicaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
