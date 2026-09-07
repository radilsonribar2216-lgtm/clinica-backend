package com.uniminuto.clinica.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Estructura estandar utilizada para representar los errores devueltos
 * por la API REST del sistema.
 */
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

    /** Momento en que ocurrio el error. */
    private LocalDateTime timestamp;

    /** Codigo de estado HTTP asociado al error. */
    private int status;

    /** Mensaje descriptivo del error. */
    private String mensaje;

    /** Ruta de la peticion que genero el error. */
    private String ruta;
}
