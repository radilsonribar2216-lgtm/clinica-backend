package com.uniminuto.clinica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entidad que representa una formula medica registrada para una cita.
 *
 * <p>Corresponde a la tabla {@code formula_medica} del esquema {@code clinica}.
 * Cada formula esta asociada a una cita y a un medicamento del inventario.</p>
 */
@Entity
@Table(name = "formula_medica")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormulaMedica {

    /** Identificador unico de la formula medica. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Identificador de la cita a la que pertenece la formula. */
    @Column(name = "cita_id", nullable = false)
    private Integer citaId;

    /** Identificador del medicamento formulado. */
    @Column(name = "medicamento_id", nullable = false)
    private Integer medicamentoId;

    /** Dosis indicada para el medicamento (por ejemplo "500 mg cada 8 horas"). */
    @Column(name = "dosis", nullable = false, columnDefinition = "TEXT")
    private String dosis;

    /** Indicaciones adicionales para el paciente. */
    @Column(name = "indicaciones", columnDefinition = "TEXT")
    private String indicaciones;

    /** Fecha y hora en la que se creo el registro de la formula. */
    @Column(name = "fecha_creacion_registro", nullable = false)
    private LocalDateTime fechaCreacionRegistro;

    /** Fecha y hora de la ultima actualizacion del registro, si aplica. */
    @Column(name = "fecha_actualizacion_registro")
    private LocalDateTime fechaActualizacionRegistro;
}
