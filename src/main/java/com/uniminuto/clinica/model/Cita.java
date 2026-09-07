package com.uniminuto.clinica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entidad que representa una cita programada en la clinica veterinaria.
 *
 * <p>Corresponde a la tabla {@code cita} del esquema {@code clinica}.
 * Relaciona a un cliente, una mascota y un medico en una fecha y hora
 * determinada.</p>
 */
@Entity
@Table(name = "cita")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cita {

    /** Identificador unico de la cita. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Identificador del cliente (dueno de la mascota). */
    @Column(name = "cliente_id", nullable = false)
    private Integer clienteId;

    /** Identificador de la mascota atendida. */
    @Column(name = "mascota_id", nullable = false)
    private Integer mascotaId;

    /** Identificador del medico asignado a la cita. */
    @Column(name = "medico_id", nullable = false)
    private Integer medicoId;

    /** Fecha y hora programada para la cita. */
    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    /** Estado actual de la cita (por ejemplo "programada", "cancelada", "atendida"). */
    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

    /** Motivo de la consulta. */
    @Column(name = "motivo", columnDefinition = "TEXT")
    private String motivo;
}
