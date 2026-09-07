package com.uniminuto.clinica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * DTO utilizado para exponer la informacion de una formula medica
 * a traves de la API REST, evitando exponer directamente la entidad JPA.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormulaMedicaDTO {

    /** Identificador de la formula medica. */
    private Long id;

    /** Identificador de la cita asociada. */
    private Integer citaId;

    /** Identificador del medicamento formulado. */
    private Integer medicamentoId;

    /** Dosis indicada. */
    private String dosis;

    /** Indicaciones adicionales. */
    private String indicaciones;

    /** Fecha de creacion del registro. */
    private LocalDateTime fechaCreacionRegistro;

    /** Fecha de la ultima actualizacion del registro. */
    private LocalDateTime fechaActualizacionRegistro;
}
