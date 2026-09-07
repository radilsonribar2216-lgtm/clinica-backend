package com.uniminuto.clinica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * DTO utilizado para exponer la informacion de una historia medica
 * a traves de la API REST.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoriaMedicaDTO {

    /** Identificador de la historia medica. */
    private Long id;

    /** Identificador del paciente (mascota). */
    private Integer pacienteId;

    /** Fecha de creacion de la historia medica. */
    private LocalDateTime fechaCreacion;
}
