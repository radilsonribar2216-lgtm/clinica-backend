package com.uniminuto.clinica.controller;

import com.uniminuto.clinica.dto.FormulaMedicaDTO;
import com.uniminuto.clinica.service.FormulaMedicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST que expone los servicios relacionados con las
 * formulas medicas del inventario de la clinica veterinaria.
 *
 * <p>Requerimiento 1: listar las formulas medicas ordenadas por fecha
 * de creacion, de la mas reciente a la mas antigua.</p>
 */
@RestController
@RequestMapping("/api/formulas")
public class FormulaMedicaController {

    private final FormulaMedicaService formulaMedicaService;

    /**
     * Constructor con inyeccion de dependencias.
     *
     * @param formulaMedicaService servicio de formulas medicas
     */
    public FormulaMedicaController(FormulaMedicaService formulaMedicaService) {
        this.formulaMedicaService = formulaMedicaService;
    }

    /**
     * Lista todas las formulas medicas del inventario, ordenadas por
     * fecha de creacion descendente (de la mas reciente a la mas antigua).
     *
     * @return lista de formulas medicas con codigo HTTP 200
     */
    @GetMapping
    public ResponseEntity<List<FormulaMedicaDTO>> listarFormulas() {
        return ResponseEntity.ok(formulaMedicaService.listarFormulas());
    }
}
