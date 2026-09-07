package com.uniminuto.clinica.repository;

import com.uniminuto.clinica.model.FormulaMedica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositorio JPA para el acceso a datos de la entidad {@link FormulaMedica}.
 */
public interface FormulaMedicaRepository extends JpaRepository<FormulaMedica, Long> {

    /**
     * Obtiene todas las formulas medicas ordenadas por fecha de creacion
     * del registro, de la mas reciente a la mas antigua.
     *
     * @return lista de formulas medicas ordenada descendentemente por fecha de creacion
     */
    List<FormulaMedica> findAllByOrderByFechaCreacionRegistroDesc();
}
