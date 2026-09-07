package com.uniminuto.clinica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entidad que representa una anotacion realizada por un medico dentro
 * de la historia medica de un paciente.
 *
 * <p>Corresponde a la tabla {@code anotacion_historia} del esquema
 * {@code clinica}.</p>
 */
@Entity
@Table(name = "anotacion_historia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnotacionHistoria {

    /** Identificador unico de la anotacion. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Identificador de la historia medica a la que pertenece la anotacion. */
    @Column(name = "historia_id", nullable = false)
    private Integer historiaId;

    /** Identificador del medico que realiza la anotacion. */
    @Column(name = "medico_id", nullable = false)
    private Integer medicoId;

    /** Fecha y hora en que se realizo la anotacion. */
    @Column(name = "fecha")
    private LocalDateTime fecha;

    /** Contenido/descripcion de la anotacion clinica. */
    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;
}
