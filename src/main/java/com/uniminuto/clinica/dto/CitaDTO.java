package com.uniminuto.clinica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * DTO utilizado para exponer la informacion de una cita a traves
 * de la API REST.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CitaDTO {

    /** Identificador de la cita. */
    private Long id;

    /** Identificador del cliente. */
    private Integer clienteId;

    /** Identificador de la mascota. */
    private Integer mascotaId;

    /** Identificador del medico. */
    private Integer medicoId;

    /** Fecha y hora de la cita. */
    private LocalDateTime fechaHora;

    /** Estado de la cita. */
    private String estado;

    /** Motivo de la consulta. */
    private String motivo;
}
