package com.uniminuto.clinica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * DTO de entrada utilizado para crear o actualizar una cita.
 *
 * <p>Contiene validaciones basicas para asegurar que los datos minimos
 * requeridos por la tabla {@code cita} sean enviados por el cliente.</p>
 */
@Getter
@Setter
public class CitaRequestDTO {

    /** Identificador del cliente. Obligatorio. */
    @NotNull(message = "El clienteId es obligatorio")
    private Integer clienteId;

    /** Identificador de la mascota. Obligatorio. */
    @NotNull(message = "El mascotaId es obligatorio")
    private Integer mascotaId;

    /** Identificador del medico. Obligatorio. */
    @NotNull(message = "El medicoId es obligatorio")
    private Integer medicoId;

    /** Fecha y hora de la cita. Obligatoria. */
    @NotNull(message = "La fechaHora es obligatoria")
    private LocalDateTime fechaHora;

    /** Estado de la cita. Obligatorio (por ejemplo: programada, cancelada, atendida). */
    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    /** Motivo de la consulta. Opcional. */
    private String motivo;
}
