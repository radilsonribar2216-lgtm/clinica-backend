package com.uniminuto.clinica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO de entrada utilizado para crear o actualizar una anotacion
 * de historia medica.
 */
@Getter
@Setter
public class AnotacionHistoriaRequestDTO {

    /** Identificador de la historia medica a la que pertenece. Obligatorio. */
    @NotNull(message = "El historiaId es obligatorio")
    private Integer historiaId;

    /** Identificador del medico que realiza la anotacion. Obligatorio. */
    @NotNull(message = "El medicoId es obligatorio")
    private Integer medicoId;

    /** Descripcion de la anotacion clinica. Obligatoria. */
    @NotBlank(message = "La descripcion es obligatoria")
    private String descripcion;
}
