package com.uniminuto.clinica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entidad que representa la historia medica de un paciente (mascota).
 *
 * <p>Corresponde a la tabla {@code historia_medica} del esquema {@code clinica}.
 * Se relaciona con la tabla {@code anotacion_historia} a traves del campo
 * {@code historia_id}, manejado de forma simple (sin mapear la relacion
 * bidireccional en JPA) para mantener el codigo claro y facil de sustentar.</p>
 */
@Entity
@Table(name = "historia_medica")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoriaMedica {

    /** Identificador unico de la historia medica. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Identificador del paciente (mascota) al que pertenece la historia. */
    @Column(name = "paciente_id", nullable = false)
    private Integer pacienteId;

    /** Fecha de creacion de la historia medica. */
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
}
