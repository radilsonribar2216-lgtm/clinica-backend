package com.uniminuto.clinica.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO de entrada utilizado para crear o actualizar una historia medica.
 */
@Getter
@Setter
public class HistoriaMedicaRequestDTO {

    /** Identificador del paciente (mascota). Obligatorio. */
    @NotNull(message = "El pacienteId es obligatorio")
    private Integer pacienteId;
}
