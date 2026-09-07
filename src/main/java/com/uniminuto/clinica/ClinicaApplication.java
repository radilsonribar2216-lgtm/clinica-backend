package com.uniminuto.clinica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que arranca la aplicacion Spring Boot del backend
 * de la Clinica Veterinaria.
 *
 * <p>Esta clase contiene el metodo {@code main}, punto de entrada
 * de la aplicacion, el cual delega en {@link SpringApplication} el
 * proceso de inicializacion del contexto de Spring.</p>
 */
@SpringBootApplication
public class ClinicaApplication {

    /**
     * Metodo de entrada de la aplicacion.
     *
     * @param args argumentos de linea de comandos recibidos al ejecutar la aplicacion
     */
    public static void main(String[] args) {
        SpringApplication.run(ClinicaApplication.class, args);
    }
}
