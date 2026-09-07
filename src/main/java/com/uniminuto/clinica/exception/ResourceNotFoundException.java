package com.uniminuto.clinica.exception;

/**
 * Excepcion lanzada cuando un recurso solicitado (cita, formula medica,
 * historia medica o anotacion) no existe en la base de datos.
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Crea la excepcion con un mensaje descriptivo.
     *
     * @param mensaje detalle del recurso que no fue encontrado
     */
    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}
