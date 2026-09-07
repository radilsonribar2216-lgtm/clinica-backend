package com.uniminuto.clinica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * DTO utilizado para exponer la informacion de una anotacion de
 * historia medica a traves de la API REST.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnotacionHistoriaDTO {

    /** Identificador de la anotacion. */
    private Long id;

    /** Identificador de la historia medica asociada. */
    private Integer historiaId;

    /** Identificador del medico que realizo la anotacion. */
    private Integer medicoId;

    /** Fecha y hora de la anotacion. */
    private LocalDateTime fecha;

    /** Descripcion de la anotacion. */
    private String descripcion;
}
